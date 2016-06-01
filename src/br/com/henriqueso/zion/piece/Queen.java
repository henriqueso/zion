package br.com.henriqueso.zion.piece;

import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class Queen extends ChessPiece {

	@Override
	public List<Position> threatens(ChessBoard chessBoard) {
		// TODO: Implement how Queen attacks
		return null;
	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public Integer getThreatLevel() {
		return Integer.valueOf(5);
	}
}
