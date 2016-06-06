package br.com.henriqueso.zion.piece;

import java.util.ArrayList;
import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class Bishop extends ChessPiece {

	public Bishop() {
		setName("B");
	}
	
	@Override
	public List<Position> threatens(ChessBoard chessBoard) {
		List<Position> threatened = new ArrayList<>();
		
		southEast(chessBoard, threatened);
		southWest(chessBoard, threatened);
		northWest(chessBoard, threatened);
		northEast(chessBoard, threatened);
		
		return threatened;
	}

	private void southEast(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() + 1;
		int threatenedY = getPosition().getY() + 1;
		
		for (; threatenedY < chessBoard.getColumns() && threatenedX < chessBoard.getRows(); threatenedX++, threatenedY++) {
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

	private void northWest(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() - 1;
		int threatenedY = getPosition().getY() - 1;
		
		for (; threatenedY >= 0 && threatenedX >= 0; threatenedY--, threatenedX--) {
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
	
	private void addPosition(ChessBoard chessBoard, List<Position> threatened, int threatenedX, int threatenedY) {
		Position position = new Position(threatenedX, threatenedY);
		
		if (chessBoard.isValidPosition(position)){
			threatened.add(position);
		}
	}

	@Override
	public Integer getThreatLevel() {
		return Integer.valueOf(4);
	}

	private static final long serialVersionUID = 1L;
}
