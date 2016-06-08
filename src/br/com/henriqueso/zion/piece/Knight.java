package br.com.henriqueso.zion.piece;

import java.util.ArrayList;
import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class Knight extends ChessPiece {

	public Knight() {
		setName("N");
	}
	
	@Override
	public List<Position> threatens(ChessBoard chessBoard, Position position) {
		List<Position> threatened = new ArrayList<>();
		
		bottomRight(chessBoard, threatened, position);
		bottomLeft(chessBoard, threatened, position);
		topRight(chessBoard, threatened, position);
		topLeft(chessBoard, threatened, position);

		return threatened;
	}

	@Override
	public Integer getThreatLevel() {
		return Integer.valueOf(2);
	}

	private void bottomLeft(ChessBoard chessBoard, List<Position> threatened, Position position) {
		addPosition(chessBoard, threatened, position.getX() + 1, position.getY() - 2);
		addPosition(chessBoard, threatened, position.getX() + 2, position.getY() - 1);
	}

	private void bottomRight(ChessBoard chessBoard, List<Position> threatened, Position position) {
		addPosition(chessBoard, threatened, position.getX() + 1, position.getY() + 2);
		addPosition(chessBoard, threatened, position.getX() + 2, position.getY() + 1);
	}
	
	private void topLeft(ChessBoard chessBoard, List<Position> threatened, Position position) {
		addPosition(chessBoard, threatened, position.getX() - 1, position.getY() - 2);
		addPosition(chessBoard, threatened, position.getX() - 2, position.getY() - 1);
	}
	
	private void topRight(ChessBoard chessBoard, List<Position> threatened, Position position) {
		addPosition(chessBoard, threatened, position.getX() - 1, position.getY() + 2);
		addPosition(chessBoard, threatened, position.getX() - 2, position.getY() + 1);
	}

	private static final long serialVersionUID = 1L;
}
