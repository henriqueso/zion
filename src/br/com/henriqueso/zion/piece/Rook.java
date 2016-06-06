package br.com.henriqueso.zion.piece;

import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class Rook extends ChessPiece {

	@Override
	public List<Position> threatens(ChessBoard chessBoard) {
		// TODO: Implement how Rook attacks
		return null;
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
