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
	public List<Position> threatens(final ChessBoard chessBoard, final Position position) {
		List<Position> threatened = new ArrayList<>();
		
		north(chessBoard, threatened, position, false);
		northEast(chessBoard, threatened, position, false);
		east(chessBoard, threatened, position, false);
		southEast(chessBoard, threatened, position, false);
		south(chessBoard, threatened, position, false);
		southWest(chessBoard, threatened, position, false);
		west(chessBoard, threatened, position, false);
		northWest(chessBoard, threatened, position, false);
		
		return threatened;
	}

	@Override
	public Integer getThreatLevel() {
		return Integer.valueOf(3);
	}

	private static final long serialVersionUID = 1L;
}
