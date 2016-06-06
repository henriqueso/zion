package br.com.henriqueso.zion.piece;

import java.util.ArrayList;
import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class Rook extends ChessPiece {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Position> threatens(ChessBoard chessBoard) {
		List<Position> threatened = new ArrayList<>();
		
		right(chessBoard, threatened);
		bottom(chessBoard, threatened);
		left(chessBoard, threatened);
		top(chessBoard, threatened);
		
		return threatened;
	}

	private void right(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX();
		int threatenedY = getPosition().getY() + 1;
		
		for (; threatenedY < chessBoard.getColumns(); threatenedY++) {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);	
		}
				
	}

	private void bottom(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() + 1;
		int threatenedY = getPosition().getY();
		
		for (; threatenedX < chessBoard.getRows(); threatenedX++) {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);	
		}
	}

	private void left(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX();
		int threatenedY = getPosition().getY() - 1;
		
		for (; threatenedY >= 0; threatenedY--) {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);	
		}
	}

	private void top(ChessBoard chessBoard, List<Position> threatened) {
		int threatenedX = getPosition().getX() - 1;
		int threatenedY = getPosition().getY();
	
		for (; threatenedX >= 0; threatenedX--) {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);	
		}
	}

	private void addPosition(final ChessBoard chessBoard, final List<Position> threatened, final int threatenedX, final int threatenedY) {
		Position position = new Position(threatenedX, threatenedY);
		
		if (chessBoard.isValidPosition(position)){
			threatened.add(position);
		}
	}
	
	@Override
	public String getName() {
		return "R";
	}

	@Override
	public Integer getThreatLevel() {
		return Integer.valueOf(4);
	}
}
