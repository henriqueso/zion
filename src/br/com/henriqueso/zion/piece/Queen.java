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
	public List<Position> threatens(final ChessBoard chessBoard, final Position position) {
		List<Position> threatened = new ArrayList<>();
		
		north(chessBoard, threatened, position, true);
		northEast(chessBoard, threatened, position, true);
		east(chessBoard, threatened, position, true);
		southEast(chessBoard, threatened, position, true);
		south(chessBoard, threatened, position, true);
		southWest(chessBoard, threatened, position, true);
		west(chessBoard, threatened, position, true);
		northWest(chessBoard, threatened, position, true);
		
		return threatened;
	}

	@Override
	public Integer getThreatLevel() {
		return Integer.valueOf(5);
	}
	
	private static final long serialVersionUID = 1L;
}
