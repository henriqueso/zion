package br.com.henriqueso.zion.piece;

import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class Bishop extends ChessPiece {

	@Override
	public List<Position> threatens(ChessBoard chessBoard) {
		// TODO: Implement how bishop attacks
		return null;
	}

	@Override
	public String getName() {
		return "B";
	}

	@Override
	public Integer getThreatLevel() {
		return Integer.valueOf(4);
	}
}
