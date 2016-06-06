package br.com.henriqueso.app;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.SerializationUtils;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;
import br.com.henriqueso.zion.exceptions.NoAvailablePositionException;
import br.com.henriqueso.zion.exceptions.ThreatenedPieceException;
import br.com.henriqueso.zion.piece.Bishop;
import br.com.henriqueso.zion.piece.ChessPiece;
import br.com.henriqueso.zion.piece.ChessPieceComparator;
import br.com.henriqueso.zion.piece.Knight;
import br.com.henriqueso.zion.piece.Rook;

public class ChessApp {

	private Set<ChessBoard> uniqueBoards = new HashSet<>();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		int rows = 4;
		int columns = 4;
		
		List<ChessPiece> pieces = new ArrayList<>();
		pieces.add(new Knight());
		pieces.add(new Knight());
		pieces.add(new Rook());
		pieces.add(new Rook());
		pieces.add(new Bishop());
		pieces.add(new Bishop());
				
		Collections.sort(pieces, new ChessPieceComparator());
				
		ChessApp app = new ChessApp();
		app.addPieces(pieces, new ChessBoard(rows, columns));
		
		long end = System.currentTimeMillis();
		System.out.println("Took " + (end - start) + " milliseconds.");
	}
	
	private void addPieces(List<ChessPiece> pieces, ChessBoard board) {
		try {
			
			if ( !pieces.isEmpty() ) {
				ChessBoard chessBoard = null;
				
				Iterator<Position> iterator = board.getAvailablePositions().iterator();
				while (iterator.hasNext()) {
					Position next = iterator.next();
					
					chessBoard = SerializationUtils.clone(board);
					
					try {
						
						addPiece(pieces.get(0), next, chessBoard);
						addPieces(pieces.subList(1, pieces.size()), chessBoard);
						
					} catch (NoAvailablePositionException | ThreatenedPieceException bex) {
//							System.out.println(Thread.currentThread().getName() + " not possible");
					}
					
				}
				
			} else {
				
				if (!uniqueBoards.contains(board)) {
					System.out.println(board);
					
					uniqueBoards.add(board);
				}
			}
		
		} catch (RuntimeException rex) {
			rex.printStackTrace();
		}
		
	}


	private void addPiece(ChessPiece piece, Position position, ChessBoard board) {
		try {

			board.put(piece, position);
			
		} catch (ThreatenedPieceException rex) {
			throw rex;
		}
		
		
	}

}