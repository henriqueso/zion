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
		
		newPosition = bottomRight(1, 2);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = bottomRight(2, 1);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = bottomLeft(1, 2);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = bottomLeft(2, 1);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = topRight(1, 2);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = topRight(2, 1);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = topLeft(1, 2);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}
		
		newPosition = topLeft(2, 1);
		if (chessBoard.isValidPosition(newPosition)) {
			threatened.add(newPosition);
		}

		return threatened;
	}

	@Override
	public Integer getThreatLevel() {
		return Integer.valueOf(2);
	}

	private Position bottomLeft(int down, int left) {
		int threatenedX = getPosition().getX() + down;
		int threatenedY = getPosition().getY() - left;

		return new Position(threatenedX, threatenedY);
	}

	private Position bottomRight(int down, int right) {
		int threatenedX = getPosition().getX() + down;
		int threatenedY = getPosition().getY() + right;
		
		return new Position(threatenedX, threatenedY);
	}
	
	private Position topLeft(int up, int left) {
		int threatenedX = getPosition().getX() - up;
		int threatenedY = getPosition().getY() - left;
		
		return new Position(threatenedX, threatenedY);
	}
	
	private Position topRight(int up, int right) {
		int threatenedX = getPosition().getX() - up;
		int threatenedY = getPosition().getY() + right;
		
		return new Position(threatenedX, threatenedY);
	}

	@Override
	public String getName() {
		return "N";
	}
}
