package br.com.henriqueso.zion.piece;

import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class Bishop extends ChessPiece {

	public Bishop() {
		setName("B");
	}
	
	@Override
	public List<Position> threatens(ChessBoard chessBoard) {
		// TODO: Implement how bishop attacks
		return null;
	}

	@Override
	public Integer getThreatLevel() {
		return Integer.valueOf(4);
	}

	private static final long serialVersionUID = 1L;
}
