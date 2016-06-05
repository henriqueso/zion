package br.com.henriqueso.app;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;
import br.com.henriqueso.zion.exceptions.NoAvailablePositionException;
import br.com.henriqueso.zion.exceptions.ThreatenedPieceException;
import br.com.henriqueso.zion.piece.ChessPiece;
import br.com.henriqueso.zion.piece.ChessPieceComparator;
import br.com.henriqueso.zion.piece.King;
import br.com.henriqueso.zion.piece.Knight;

public class ChessApp implements Runnable {

	private List<ChessPiece> pieces;
	private Position firstPosition;
	private ChessBoard board;


	public ChessApp(List<ChessPiece> pieces, Position position, ChessBoard board) {
		this.pieces = pieces;
		this.firstPosition = position;
		this.board = board;
	}


	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		int rows = 3;
		int columns = 3;
		
		for (int row = 0; row < rows; row++) {
			
			for (int column = 0; column < columns; column++) {
				List<ChessPiece> pieces = Arrays.asList(new King(), new Knight(), new Knight());
				
				Collections.sort(pieces, new ChessPieceComparator());
				
				Position initialPosition = new Position(row, column);
				ChessApp app = new ChessApp(pieces, initialPosition, new ChessBoard(rows, columns));

				new Thread(app, initialPosition.toString()).start();
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Took " + (end - start) + " milliseconds.");
	}
	
	
	private void addPieces(List<ChessPiece> pieces, Position position, ChessBoard board) {
		try {
			Position piecePosition = position;
			for (ChessPiece piece : pieces) {
				addPiece(piece, piecePosition, board);
				
				if (board.getAvailablePositions().iterator().hasNext()) {
					piecePosition = board.getAvailablePositions().iterator().next();
				} else {
					throw new NoAvailablePositionException();
				}
			}
			
			System.out.println(Thread.currentThread().getName() + board);
			System.out.println("-----------------");
		
		} catch (NoAvailablePositionException | ThreatenedPieceException bex) {
//			System.out.println(Thread.currentThread().getName() + " not possible");
			
		} catch (RuntimeException rex) {
			rex.printStackTrace();
			
		}
		
	}


	private void addPiece(ChessPiece piece, Position position, ChessBoard board) {
		try {

			board.put(piece, position);
			
		} catch (ThreatenedPieceException rex) {
			
			if ( board.getAvailablePositions().iterator().hasNext() ) {
				Position next = board.getAvailablePositions().iterator().next();
			
				addPiece(piece, next, board);
			} else {
				throw rex;
			}
		}
		
		
	}


	@Override
	public void run() {
		addPieces(pieces, firstPosition, board);
		
	}

}
