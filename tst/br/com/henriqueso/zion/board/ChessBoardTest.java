package br.com.henriqueso.zion.board;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Assert;
import org.junit.Test;

import br.com.henriqueso.zion.exceptions.NoAvailablePositionException;
import br.com.henriqueso.zion.piece.King;
import br.com.henriqueso.zion.piece.Knight;
import br.com.henriqueso.zion.piece.Rook;

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
	
	@Test
	public void testBoardsAreEqual() {
		ChessBoard board1 = new ChessBoard(3, 3);
		
		board1.put(new King(), new Position(0,0));
		board1.put(new King(), new Position(0,2));
		board1.put(new Rook(), new Position(2,1));
		
		ChessBoard board2 = SerializationUtils.clone(board1);
		
		Assert.assertEquals(board1, board2);
	}
	

	
	@Test
	public void testBoardsAreDifferent() {
		ChessBoard board1 = new ChessBoard(3, 3);
		ChessBoard board2 = new ChessBoard(3, 3);
		
		
		board1.put(new King(), new Position(0,0));
		board1.put(new King(), new Position(0,2));
		board1.put(new Rook(), new Position(2,1));
		
		board2.put(new King(), new Position(2,0));
		board2.put(new King(), new Position(2,2));
		board2.put(new Rook(), new Position(0,1));
		
		Assert.assertNotEquals(board1, board2);
	}

}
