package br.com.henriqueso.zion.piece;

import java.util.ArrayList;
import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class Queen extends ChessPiece {
	
	public Queen() {
		setName("Q");
	}

	@Override
	public List<Position> threatens(ChessBoard chessBoard) {
		List<Position> threatened = new ArrayList<>();
		
		north(chessBoard, threatened);
		northEast(chessBoard, threatened);
		east(chessBoard, threatened);
		southEast(chessBoard, threatened);
		south(chessBoard, threatened);
		southWest(chessBoard, threatened);
		west(chessBoard, threatened);
		northWest(chessBoard, threatened);
		
		return threatened;
	}

	private void north(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() - 1;
		int threatenedY = getPosition().getY();
	
		for (; threatenedX >= 0; threatenedX--) {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);	
		}
	}

	private void northEast(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() - 1;
		int threatenedY = getPosition().getY() + 1;
		
		for (; threatenedX >= 0 && threatenedY < chessBoard.getColumns(); threatenedY++, threatenedX--) {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);	
		}
	}

	private void east(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX();
		int threatenedY = getPosition().getY() + 1;
		
		for (; threatenedY < chessBoard.getColumns(); threatenedY++) {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);	
		}
	}

	private void southEast(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() + 1;
		int threatenedY = getPosition().getY() + 1;
		
		for (; threatenedY < chessBoard.getColumns() && threatenedX < chessBoard.getRows(); threatenedX++, threatenedY++) {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);	
		}
	}

	private void south(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() + 1;
		int threatenedY = getPosition().getY();
		
		for (; threatenedX < chessBoard.getRows(); threatenedX++) {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);	
		}
	}

	private void southWest(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() + 1;
		int threatenedY = getPosition().getY() - 1;
		
		for (; threatenedY >= 0 && threatenedX < chessBoard.getRows(); threatenedY--, threatenedX++) {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);	
		}
	}

	private void west(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX();
		int threatenedY = getPosition().getY() - 1;
		
		for (; threatenedY >= 0; threatenedY--) {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);	
		}
	}

	private void northWest(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() - 1;
		int threatenedY = getPosition().getY() - 1;
		
		for (; threatenedY >= 0 && threatenedX >= 0; threatenedY--, threatenedX--) {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);	
		}
	}

	private void addPosition(ChessBoard chessBoard, List<Position> threatened, int threatenedX, int threatenedY) {
		Position position = new Position(threatenedX, threatenedY);
		
		if (chessBoard.isValidPosition(position)){
			threatened.add(position);
		}
	}

	@Override
	public Integer getThreatLevel() {
		return Integer.valueOf(5);
	}
	
	private static final long serialVersionUID = 1L;
}
