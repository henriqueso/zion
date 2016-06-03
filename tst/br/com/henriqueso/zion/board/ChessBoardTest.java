package br.com.henriqueso.zion.board;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.henriqueso.zion.exceptions.NoAvailablePositionException;
import br.com.henriqueso.zion.piece.King;
import br.com.henriqueso.zion.piece.Knight;

public class ChessBoardTest {

	@Test
	public void testValidPosition() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 */
		ChessBoard chessBoard = new ChessBoard(3, 3);
		
		/**
		 *  WHEN verifying whether position 1,2 is valid
		 */
		boolean valid = chessBoard.isValidPosition(new Position(1, 2));
		
		
		/**
		 *  THEN should return TRUE
		 */
		assertTrue(valid);
	}
	
	@Test(expected = NoAvailablePositionException.class)
	public void testPutPieceWhenNoAvailablePositions() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 */
		ChessBoard chessBoard = new ChessBoard(3, 3);
		
		chessBoard.put(new King(), new Position(1,1));
		chessBoard.put(new Knight(), new Position(2,1));
	}

}
