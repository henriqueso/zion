package br.com.henriqueso.zion.board;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.henriqueso.zion.piece.ChessPiece;

public class ChessBoard {

	private Set<Position> available;
	private Map<Position, ChessPiece> pieces;
	private int rows;
	private int columns;

	public ChessBoard(final int rows, final int columns) {
		this.rows = rows;
		this.columns = columns;
		
		available = new HashSet<>();
		pieces = new HashMap<>();
		
		for (int row = 0; row < rows; row++) {
			
			for (int column = 0; column < columns; column++) {
				available.add(new Position(row, column));
			}
		}
	}
	
	public void put(final ChessPiece piece) {
		Position position = getAvailablePosition();
		
		if (position != null) {
			pieces.put(position, piece);
			available.remove(position);
			
			piece.setPosition(position);
			
			List<Position> threatens = piece.threatens(this);
			available.removeAll(threatens);
			
			if (!threatens.isEmpty() && pieces.keySet().containsAll(threatens)) {
				throw new RuntimeException("There is threatened pieces " + position);
			}
		} else {
			throw new RuntimeException("There is no available positions");
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
					sBuffer.append(" " + piece.toString() + " ");
					
				} else if(available.contains(position)) {
					sBuffer.append(position);
					
				} else {
					sBuffer.append("   ");
				}
				
				sBuffer.append("|");
			}
		}
		
		return sBuffer.toString();
	}

	private Position getAvailablePosition() {
		Position position = null;
		
		if (!available.isEmpty()) {
			position = available.iterator().next();
		}
		
		return position;
	}
}
