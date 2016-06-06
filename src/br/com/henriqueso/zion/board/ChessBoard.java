package br.com.henriqueso.zion.board;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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

	public synchronized void put(final ChessPiece piece, final Position position) {
		
		if (position != null && available.contains(position)) {
			piece.setPosition(position);
			List<Position> threatens = piece.threatens(this);
			
			// TODO: Remove only after checking current positions
			available.remove(position);
			
			checkCurrentPositions(threatens);

			available.removeAll(threatens);
			pieces.put(position, piece);
		} else {
			throw new NoAvailablePositionException();
		}
	}
	
	private synchronized void checkCurrentPositions(final List<Position> threatens) {
		if (!pieces.isEmpty() && !Collections.disjoint(threatens, pieces.keySet())) {
			throw new ThreatenedPieceException();
		}
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

	public Set<Position> getAvailablePositions() {
		return Collections.unmodifiableSet(available);
	}

}
