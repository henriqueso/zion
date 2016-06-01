package br.com.henriqueso.zion.board;

import static org.junit.Assert.*;

import org.junit.Test;

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
	
	@Test
	public void testPutPieceWhenNoAvailablePositions() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 */
		ChessBoard chessBoard = new ChessBoard(3, 3);
		try {
			chessBoard.put(new King(), new Position(1,1));
			chessBoard.put(new Knight(), new Position(2,1));
		} catch (RuntimeException rex) {
			assertEquals("There is no available positions", rex.getMessage());
		}
	}

}
