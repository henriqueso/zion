package br.com.henriqueso.zion.piece;

import java.io.Serializable;
import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public abstract class ChessPiece implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Position position;

	public Position getPosition() {
		return position;
	}

	public synchronized void setPosition(Position position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(getName());
		
		if (position != null) {
			sb.append(" on ").append(position);
		}
		
		return sb.toString();
	}
	
	public abstract List<Position> threatens(ChessBoard chessBoard);
	public abstract Integer getThreatLevel();
	public abstract String getName();
}
