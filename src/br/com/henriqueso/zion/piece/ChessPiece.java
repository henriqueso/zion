package br.com.henriqueso.zion.piece;

import java.io.Serializable;
import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public abstract class ChessPiece implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Position position;
	private String name;

	Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ChessPiece)) {
			return false;
		}
		ChessPiece other = (ChessPiece) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
