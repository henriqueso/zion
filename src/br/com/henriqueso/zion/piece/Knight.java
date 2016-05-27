package br.com.henriqueso.zion.piece;

import java.util.ArrayList;
import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class Knight extends ChessPiece {

	@Override
	public List<Position> threatens(ChessBoard chessBoard) {
		List<Position> threatened = new ArrayList<>();
		
		Position newPosition = null;
		
		newPosition = downRight(1, 2);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = downRight(2, 1);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = downLeft(1, 2);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = downLeft(2, 1);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = upRight(1, 2);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = upRight(2, 1);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = upLeft(1, 2);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = upLeft(2, 1);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}

		return threatened;
	}

	private Position downLeft(int down, int left) {
		int threatenedX = getPosition().getX() + down;
		int threatenedY = getPosition().getY() - left;

		return new Position(threatenedX, threatenedY);
	}

	private Position downRight(int down, int right) {
		int threatenedX = getPosition().getX() + down;
		int threatenedY = getPosition().getY() + right;
		
		return new Position(threatenedX, threatenedY);
	}
	
	private Position upLeft(int up, int left) {
		int threatenedX = getPosition().getX() - up;
		int threatenedY = getPosition().getY() - left;
		
		return new Position(threatenedX, threatenedY);
	}
	
	private Position upRight(int up, int right) {
		int threatenedX = getPosition().getX() - up;
		int threatenedY = getPosition().getY() + right;
		
		return new Position(threatenedX, threatenedY);
	}

	@Override
	public String toString() {
		return "N";
	}
}
