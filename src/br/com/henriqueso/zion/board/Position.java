package br.com.henriqueso.zion.board;

public class Position {

	private int x;
	private int y;
	
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		
		if (this == obj) {
			isEquals = true;
			
		} else if (obj != null && getClass() == obj.getClass()) {
			Position other = (Position) obj;
			
			isEquals = (x == other.x && y == other.y);
		}
		
		return isEquals;
	}

	@Override
	public String toString() {
		return x + "," + y;
	}
	
	
	
}
