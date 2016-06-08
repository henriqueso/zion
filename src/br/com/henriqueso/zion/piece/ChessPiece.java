package br.com.henriqueso.zion.piece;

import java.io.Serializable;
import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public abstract class ChessPiece implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}
	
	void southEast(final ChessBoard chessBoard, final List<Position> threatened, final Position position, final boolean isSlider) {
		int threatenedX = position.getX() + 1;
		int threatenedY = position.getY() + 1;
		
		if (isSlider) {
			for (; threatenedY < chessBoard.getColumns() && threatenedX < chessBoard.getRows(); threatenedX++, threatenedY++) {
				addPosition(chessBoard, threatened, threatenedX, threatenedY);	
			}
		} else {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);	
		}
	}

	void southWest(final ChessBoard chessBoard, final List<Position> threatened, final Position position, final boolean isSlider) {
		int threatenedX = position.getX() + 1;
		int threatenedY = position.getY() - 1;
		
		if (isSlider) {
			for (; threatenedY >= 0 && threatenedX < chessBoard.getRows(); threatenedY--, threatenedX++) {
				addPosition(chessBoard, threatened, threatenedX, threatenedY);	
			}
		} else {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);
		}
	}

	void northWest(final ChessBoard chessBoard, final List<Position> threatened, final Position position, final boolean isSlider) {
		int threatenedX = position.getX() - 1;
		int threatenedY = position.getY() - 1;
		
		if (isSlider) {
			for (; threatenedY >= 0 && threatenedX >= 0; threatenedY--, threatenedX--) {
				addPosition(chessBoard, threatened, threatenedX, threatenedY);	
			}
		} else {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);
		}
	}

	void northEast(final ChessBoard chessBoard, final List<Position> threatened, final Position position, final boolean isSlider) {
		int threatenedX = position.getX() - 1;
		int threatenedY = position.getY() + 1;
		
		if (isSlider) {
			for (; threatenedX >= 0 && threatenedY < chessBoard.getColumns(); threatenedY++, threatenedX--) {
				addPosition(chessBoard, threatened, threatenedX, threatenedY);	
			}
		} else {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);
		}
	}

	void north(final ChessBoard chessBoard, final List<Position> threatened, final Position position, final boolean isSlider) {
		int threatenedX = position.getX() - 1;
		int threatenedY = position.getY();
	
		if (isSlider) {
			for (; threatenedX >= 0; threatenedX--) {
				addPosition(chessBoard, threatened, threatenedX, threatenedY);	
			}
		} else {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);
		}
	}

	void east(final ChessBoard chessBoard, final List<Position> threatened, final Position position, final boolean isSlider) {
		int threatenedX = position.getX();
		int threatenedY = position.getY() + 1;
		
		if (isSlider) {
			for (; threatenedY < chessBoard.getColumns(); threatenedY++) {
				addPosition(chessBoard, threatened, threatenedX, threatenedY);	
			}
		} else {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);
		}
	}

	void south(final ChessBoard chessBoard, final List<Position> threatened, final Position position, final boolean isSlider) {
		int threatenedX = position.getX() + 1;
		int threatenedY = position.getY();
		
		if (isSlider) {
			for (; threatenedX < chessBoard.getRows(); threatenedX++) {
				addPosition(chessBoard, threatened, threatenedX, threatenedY);	
			}
		} else {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);
		}
	}

	void west(final ChessBoard chessBoard, final List<Position> threatened, final Position position, final boolean isSlider) {
		int threatenedX = position.getX();
		int threatenedY = position.getY() - 1;
		
		if (isSlider) {
			for (; threatenedY >= 0; threatenedY--) {
				addPosition(chessBoard, threatened, threatenedX, threatenedY);	
			}
		} else {
			addPosition(chessBoard, threatened, threatenedX, threatenedY);
		}
	}
	
	void addPosition(ChessBoard chessBoard, List<Position> threatened, int threatenedX, int threatenedY) {
		Position position = new Position(threatenedX, threatenedY);
		
		if (chessBoard.isValidPosition(position)){
			threatened.add(position);
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(getName());
		
		return sb.toString();
	}
	
	public abstract List<Position> threatens(ChessBoard chessBoard, Position position);
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
