package br.com.henriqueso.zion.piece;

import java.util.ArrayList;
import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class Rook extends ChessPiece {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Position> threatens(final ChessBoard chessBoard, final Position position) {
		List<Position> threatened = new ArrayList<>();
		
		east(chessBoard, threatened, position, true);
		south(chessBoard, threatened, position, true);
		west(chessBoard, threatened, position, true);
		north(chessBoard, threatened, position, true);
		
		return threatened;
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
