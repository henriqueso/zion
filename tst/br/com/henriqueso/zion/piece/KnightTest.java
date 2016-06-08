package br.com.henriqueso.zion.piece;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;
import br.com.henriqueso.zion.piece.ChessPiece;
import br.com.henriqueso.zion.piece.Knight;

public class KnightTest {
	
	@Test
	public void testThreatensKnightOn_0_0() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND Knight on position 0,0
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new Knight();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(0, 0));
		
		/**
		 *  THEN it should return positions 1,2 and 2,1
		 */
		assertEquals(new Position(1, 2), threatened.get(0));
		assertEquals(new Position(2, 1), threatened.get(1));
	}
	
	@Test
	public void testThreatensKnightOn_0_1() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND Knight on position 0,1
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new Knight();
		
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(0, 1));
		
		/**
		 *  THEN it should return positions 2,2 and 2,0
		 */
		assertEquals(new Position(2, 2), threatened.get(0));
		assertEquals(new Position(2, 0), threatened.get(1));
	}
	
	@Test
	public void testThreatensKnightOn_0_2() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND Knight on position 0,2
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new Knight();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(0, 2));
		
		/**
		 *  THEN it should return positions 1,0 and 2,1
		 */
		assertEquals(new Position(1, 0), threatened.get(0));
		assertEquals(new Position(2, 1), threatened.get(1));
	}
	
	@Test
	public void testThreatensKnightOn_1_0() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND Knight on position 1,0
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new Knight();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(1, 0));
		
		/**
		 *  THEN it should return positions 2,2 and 0,2
		 */
		assertEquals(new Position(2, 2), threatened.get(0));
		assertEquals(new Position(0, 2), threatened.get(1));
	}
	
	@Test
	public void testThreatensKnightOn_1_1() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND Knight on position 1,1
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new Knight();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(1, 1));
		
		/**
		 *  THEN it should return empty
		 */
		assertTrue(threatened.isEmpty());
	}
	
	@Test
	public void testThreatensKnightOn_1_2() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND Knight on position 1,2
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new Knight();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(1, 2));
		
		/**
		 *  THEN it should return positions 2,0 and 0,0
		 */
		assertEquals(new Position(2, 0), threatened.get(0));
		assertEquals(new Position(0, 0), threatened.get(1));
	}
	
	@Test
	public void testThreatensKnightOn_2_0() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND Knight on position 2,0
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new Knight();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(2, 0));
		
		/**
		 *  THEN it should return positions 1,2 and 0,1
		 */
		assertEquals(new Position(1, 2), threatened.get(0));
		assertEquals(new Position(0, 1), threatened.get(1));
	}
	
	@Test
	public void testThreatensKnightOn_2_1() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND Knight on position 2,1
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new Knight();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(2, 1));
		
		/**
		 *  THEN it should return positions 0,2 and 0,0
		 */
		assertEquals(new Position(0, 2), threatened.get(0));
		assertEquals(new Position(0, 0), threatened.get(1));
	}
	
	@Test
	public void testThreatensKnightOn_2_2() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND Knight on position 2,2
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new Knight();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(2, 2));
		
		/**
		 *  THEN it should return positions 1,0 and 0,1
		 */
		assertEquals(new Position(1, 0), threatened.get(0));
		assertEquals(new Position(0, 1), threatened.get(1));
	}

}
