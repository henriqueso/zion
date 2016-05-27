package br.com.henriqueso.zion.board;

import static org.junit.Assert.*;

import org.junit.Test;

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

}
