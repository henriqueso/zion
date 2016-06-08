package br.com.henriqueso.zion.board;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.henriqueso.zion.exceptions.NoAvailablePositionException;
import br.com.henriqueso.zion.exceptions.ThreatenedPieceException;
import br.com.henriqueso.zion.piece.ChessPiece;

public class ChessBoard implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Set<Position> available;
	private Map<Position, ChessPiece> pieces;
	private int rows;
	private int columns;

	public ChessBoard(final int rows, final int columns) {
		this.rows = rows;
		this.columns = columns;
		
		pieces = new HashMap<>();
		
		createAvailablePositions(rows, columns);
	}

	public void put(final ChessPiece piece, final Position position) {
		
		if (position != null && available.contains(position)) {
			List<Position> threatens = piece.threatens(this, position);
			
			checkCurrentPositions(threatens);

			available.remove(position);

			available.removeAll(threatens);
			pieces.put(position, piece);
		} else {
			throw new NoAvailablePositionException();
		}
	}
	
	private void checkCurrentPositions(final List<Position> threatens) {
		if (!pieces.isEmpty()) {
			
			Iterator<Position> iterator = pieces.keySet().iterator();
			while (iterator.hasNext()) {
				if (threatens.contains(iterator.next())) {
					throw new ThreatenedPieceException();
				}
			}
		}
//		System.out.println("p:" + pieces.keySet() + "\nt:" + threatens);
	}

	private void createAvailablePositions(final int rows, final int columns) {
		available = new HashSet<>();
		
		for (int row = 0; row < rows; row++) {
			
			for (int column = 0; column < columns; column++) {
				available.add(new Position(row, column));
			}
		}
	}

	public int getRows() {
		return this.rows;
	}
	
	public int getColumns() {
		return this.columns;
	}
	
	public boolean isValidPosition(final Position position) {
		return position.getX() >= 0 &&
			   position.getY() >= 0 &&
			   position.getX() < getRows() && 
			   position.getY() < getColumns();
	}
	
	@Override
	public String toString() {
		StringBuffer sBuffer = new StringBuffer();
		
		for (int row = 0; row < rows; row++) {
			sBuffer.append("\n|");
			
			for (int column = 0; column < columns; column++) {
				
				Position position = new Position(row, column);
				
				ChessPiece piece = pieces.get(position);
				
				if (piece != null) {
					sBuffer.append(" " + piece.getName() + " ");
					
				} else if (available.contains(position)) {
					sBuffer.append("   ");
				} else {
					sBuffer.append(" * ");
				}
				
				sBuffer.append("|");
			}
		}
		
		return sBuffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columns;
		result = prime * result + ((pieces == null) ? 0 : pieces.hashCode());
		result = prime * result + rows;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChessBoard other = (ChessBoard) obj;
		if (columns != other.columns)
			return false;
		if (pieces == null) {
			if (other.pieces != null)
				return false;
		} else if (!pieces.equals(other.pieces))
			return false;
		if (rows != other.rows)
			return false;
		return true;
	}

	public Set<Position> getAvailablePositions() {
		return Collections.unmodifiableSet(available);
	}

}
