package br.com.henriqueso.app;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;
import br.com.henriqueso.zion.exceptions.NoAvailablePositionException;
import br.com.henriqueso.zion.exceptions.ThreatenedPieceException;
import br.com.henriqueso.zion.piece.ChessPiece;
import br.com.henriqueso.zion.piece.ChessPieceComparator;
import br.com.henriqueso.zion.piece.King;
import br.com.henriqueso.zion.piece.Knight;

public class ChessApp {

	private int boardCount = 0;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		int rows = 3;
		int columns = 3;
		
		List<ChessPiece> pieces = new ArrayList<>();
		pieces.add(new King());
		pieces.add(new Knight());
		pieces.add(new Knight());
				
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
				System.out.println("-------------\n"  + ++boardCount);
				System.out.println(board);
			}
		
		} catch (RuntimeException rex) {
			rex.printStackTrace();
			
		}
		
	}


	private void addPiece(ChessPiece piece, Position position, ChessBoard board) {
		try {

			board.put(piece, position);
			
		} catch (ThreatenedPieceException rex) {
			
//			if ( board.getAvailablePositions().iterator().hasNext() ) {
//				Position next = board.getAvailablePositions().iterator().next();
//			
//				addPiece(piece, next, board);
//			} else {
				throw rex;
//			}
		}
		
		
	}

}