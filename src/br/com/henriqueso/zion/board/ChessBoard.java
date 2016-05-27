package br.com.henriqueso.zion.board;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {

	private List<Position> available;
	private int rows;
	private int columns;

	public ChessBoard(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		available = new ArrayList<>();
		
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
		
		sBuffer.append("|");
		
		int row = 0;
		for (Position position : available) {
			
			if (position.getX() != row) {
				sBuffer.append("\n|");
				row = position.getX();
			}
			sBuffer.append(position.toString());
			sBuffer.append("|");
		}
		
		return sBuffer.toString();
	}

}
