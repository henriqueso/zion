package br.com.henriqueso.zion.piece;

import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public abstract class ChessPiece {
	
	private Position position;

	public Position getPosition() {
		return position;
	}

	public synchronized void setPosition(Position position) {
		this.position = position;
	}
	
	public abstract List<Position> threatens(ChessBoard chessBoard);
	public abstract Integer getThreatLevel();

}
