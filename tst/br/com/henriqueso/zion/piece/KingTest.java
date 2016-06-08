package br.com.henriqueso.zion.piece;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class KingTest {

	@Test
	public void testThreatensKingOn_0_0() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND King on position 0,0
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new King();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(0, 0));
		
		/**
		 *  THEN it should return positions 0,1 
		 *   AND 1,1 
		 *   AND 1,0
		 */
		assertEquals(3, threatened.size());
		assertEquals(new Position(0, 1), threatened.get(0));
		assertEquals(new Position(1, 1), threatened.get(1));
		assertEquals(new Position(1, 0), threatened.get(2));
	}
	
	@Test
	public void testThreatensKingOn_0_1() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND King on position 0,1
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new King();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(0, 1));
		
		/**
		 *  THEN it should return positions 0,2 
		 *   AND 1,2 
		 *   AND 1,1
		 *   AND 1,0
		 *   AND 0,0
		 */
		assertEquals(5, threatened.size());
		assertEquals(new Position(0, 2), threatened.get(0));
		assertEquals(new Position(1, 2), threatened.get(1));
		assertEquals(new Position(1, 1), threatened.get(2));
		assertEquals(new Position(1, 0), threatened.get(3));
		assertEquals(new Position(0, 0), threatened.get(4));
	}
	
	@Test
	public void testThreatensKingOn_0_2() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND King on position 0,2
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new King();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(0, 2));
		
		/**
		 *  THEN it should return positions 1,2 
		 *   AND 1,1
		 *   AND 0,1
		 */
		assertEquals(3, threatened.size());
		assertEquals(new Position(1, 2), threatened.get(0));
		assertEquals(new Position(1, 1), threatened.get(1));
		assertEquals(new Position(0, 1), threatened.get(2));
	}
	
	@Test
	public void testThreatensKingOn_1_0() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND King on position 1,0
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new King();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(1, 0));
		
		/**
		 *  THEN it should return positions 0,0 
		 *   AND 0,1 
		 *   AND 1,1 
		 *   AND 2,1 
		 *   AND 2,0
		 */
		assertEquals(5, threatened.size());
		assertEquals(new Position(0, 0), threatened.get(0));
		assertEquals(new Position(0, 1), threatened.get(1));
		assertEquals(new Position(1, 1), threatened.get(2));
		assertEquals(new Position(2, 1), threatened.get(3));
		assertEquals(new Position(2, 0), threatened.get(4));
	}
	
	@Test
	public void testThreatensKingOn_1_1() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND King on position 1,1
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new King();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(1, 1));
		
		/**
		 *  THEN it should return positions 0,1 
		 *   AND 0,2
		 *   AND 1,2 
		 *   AND 2,2 
		 *   AND 2,1 
		 *   AND 2,0
		 *   AND 1,0
		 *   AND 0,0
		 */
		assertEquals(8, threatened.size());
		assertEquals(new Position(0, 1), threatened.get(0));
		assertEquals(new Position(0, 2), threatened.get(1));
		assertEquals(new Position(1, 2), threatened.get(2));
		assertEquals(new Position(2, 2), threatened.get(3));
		assertEquals(new Position(2, 1), threatened.get(4));
		assertEquals(new Position(2, 0), threatened.get(5));
		assertEquals(new Position(1, 0), threatened.get(6));
		assertEquals(new Position(0, 0), threatened.get(7));
	}
	
	@Test
	public void testThreatensKingOn_1_2() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND King on position 1,2
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new King();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(1, 2));
		
		/**
		 *  THEN it should return positions 2,2 
		 *   AND 2,1 
		 *   AND 1,1
		 *   AND 0,1
		 *   AND 0,2
		 */
		assertEquals(5, threatened.size());
		assertEquals(new Position(0, 2), threatened.get(0));
		assertEquals(new Position(2, 2), threatened.get(1));
		assertEquals(new Position(2, 1), threatened.get(2));
		assertEquals(new Position(1, 1), threatened.get(3));
		assertEquals(new Position(0, 1), threatened.get(4));
	}
	
	@Test
	public void testThreatensKingOn_2_0() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND King on position 2,0
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new King();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(2, 0));
		
		/**
		 *  THEN it should return positions 1,0 
		 *   AND 1,1 
		 *   AND 2,1
		 */
		assertEquals(3, threatened.size());
		assertEquals(new Position(1, 0), threatened.get(0));
		assertEquals(new Position(1, 1), threatened.get(1));
		assertEquals(new Position(2, 1), threatened.get(2));
	}
	
	@Test
	public void testThreatensKingOn_2_1() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND King on position 2,1
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new King();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(2, 1));
		
		/**
		 *  THEN it should return positions 1,1 
		 *   AND 1,2 
		 *   AND 2,2
		 *   AND 2,0
		 *   AND 1,0
		 */
		assertEquals(5, threatened.size());
		assertEquals(new Position(1, 1), threatened.get(0));
		assertEquals(new Position(1, 2), threatened.get(1));
		assertEquals(new Position(2, 2), threatened.get(2));
		assertEquals(new Position(2, 0), threatened.get(3));
		assertEquals(new Position(1, 0), threatened.get(4));
	}
	
	@Test
	public void testThreatensKingOn_2_2() {
		/**
		 * GIVEN a 3x3 ChessBoard
		 *   AND King on position 2,2
		 */
		ChessBoard chessBoard = new ChessBoard(3,3);
		ChessPiece piece = new King();
		
		/**
		 *  WHEN getting the threatened positions
		 */
		List<Position> threatened = piece.threatens(chessBoard, new Position(2, 2));
		
		/**
		 *  THEN it should return positions 1,2
		 *   AND 2,1
		 *   AND 1,1 
		 */
		assertEquals(3, threatened.size());
		assertEquals(new Position(1, 2), threatened.get(0));
		assertEquals(new Position(2, 1), threatened.get(1));
		assertEquals(new Position(1, 1), threatened.get(2));
	}

}
