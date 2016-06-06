package br.com.henriqueso.zion.piece;

import java.util.ArrayList;
import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class King extends ChessPiece {

	public King() {
		setName("K");
	}
	
	@Override
	public List<Position> threatens(final ChessBoard chessBoard) {
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

	@Override
	public Integer getThreatLevel() {
		return Integer.valueOf(3);
	}

	private void north(final ChessBoard chessBoard, final List<Position> threatened) {
		int threatenedX = getPosition().getX() - 1;
		int threatenedY = getPosition().getY();
		
		addPosition(chessBoard, threatened, threatenedX, threatenedY);
	}

	private void northEast(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() - 1;
		int threatenedY = getPosition().getY() + 1;
		
		addPosition(chessBoard, threatened, threatenedX, threatenedY);
	}

	private void east(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX();
		int threatenedY = getPosition().getY() + 1;
		
		addPosition(chessBoard, threatened, threatenedX, threatenedY);
	}

	private void southEast(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() + 1;
		int threatenedY = getPosition().getY() + 1;
		
		addPosition(chessBoard, threatened, threatenedX, threatenedY);
	}

	private void south(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() + 1;
		int threatenedY = getPosition().getY();
		
		addPosition(chessBoard, threatened, threatenedX, threatenedY);
	}
	
	private void southWest(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() + 1;
		int threatenedY = getPosition().getY() - 1;
		
		addPosition(chessBoard, threatened, threatenedX, threatenedY);
	}

	private void west(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX();
		int threatenedY = getPosition().getY() - 1;
		
		addPosition(chessBoard, threatened, threatenedX, threatenedY);
	}

	private void northWest(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() - 1;
		int threatenedY = getPosition().getY() - 1;
		
		addPosition(chessBoard, threatened, threatenedX, threatenedY);
	}

	private void addPosition(ChessBoard chessBoard, List<Position> threatened, int threatenedX, int threatenedY) {
		Position position = new Position(threatenedX, threatenedY);
		
		if (chessBoard.isValidPosition(position)){
			threatened.add(position);
		}
	}
	
	private static final long serialVersionUID = 1L;
}
