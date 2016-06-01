import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;
import br.com.henriqueso.zion.piece.ChessPiece;
import br.com.henriqueso.zion.piece.King;
import br.com.henriqueso.zion.piece.Knight;

public class ChessApp {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		int rows = 3;
		int columns = 3;
		
		ChessApp app = new ChessApp();
		
		List<ChessPiece> pieces = Arrays.asList(new King(), new Knight(), new Knight());
		
		ChessBoard board = new ChessBoard(rows, columns);

		Position position = new Position(0, 0);
		
		Collections.sort(pieces, new Comparator<ChessPiece>() {

			@Override
			public int compare(ChessPiece piece1, ChessPiece piece2) {
				return piece2.getThreatLevel().compareTo(piece1.getThreatLevel());
			}
		});
		
		app.addPieces(pieces, position, board);
		
		long end = System.currentTimeMillis();
		System.out.println("Took " + (end - start) + " milliseconds.");
	}
	
	
	private void addPieces(List<ChessPiece> pieces, Position position, ChessBoard board) {
		try {
			Position piecePosition = position;
			for (ChessPiece piece : pieces) {
				addPiece(piece, piecePosition, board);
				piecePosition = board.getAvailablePositions().iterator().next();
			}
			
			System.out.println(board);
			System.out.println("-----------------");
		} catch (RuntimeException rex) {
			System.out.println(rex.getMessage());
			
			Position newPosition = null;
			if (position.getY() + 1 < board.getColumns()) {
				newPosition = new Position(position.getX(), position.getY() + 1);
			} else {
				newPosition = new Position(position.getX() + 1, 0);
			}
			
			if (board.isValidPosition(newPosition)) {
				addPieces(pieces, newPosition, new ChessBoard(board.getRows(), board.getColumns()));
			} else {
				System.out.println("Not possible");
			}
		}
		
	}


	private void addPiece(ChessPiece piece, Position position, ChessBoard board) {
		try {

			System.out.println(piece + " on " + position);
			board.put(piece, position);
			
		} catch (RuntimeException rex) {
			
			if ( board.getAvailablePositions().iterator().hasNext() ) {
				Position next = board.getAvailablePositions().iterator().next();
			
				addPiece(piece, next, board);
			} else {
				throw new RuntimeException("new board");
			}
		}
		
		
	}

}
