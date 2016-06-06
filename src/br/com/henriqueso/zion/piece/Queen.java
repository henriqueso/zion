package br.com.henriqueso.zion.piece;

import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class Queen extends ChessPiece {
	
	public Queen() {
		setName("Q");
	}

	@Override
	public List<Position> threatens(ChessBoard chessBoard) {
		// TODO: Implement how Queen attacks
		return null;
	}

	@Override
	public Integer getThreatLevel() {
		return Integer.valueOf(5);
	}
	
	private static final long serialVersionUID = 1L;
}
