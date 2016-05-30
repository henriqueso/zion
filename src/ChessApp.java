import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.piece.Knight;

public class ChessApp {

	public static void main(String[] args) {

		int rows = 3;
		int columns = 3;
		
		ChessBoard board = new ChessBoard(rows, columns);

		System.out.println(board);
		
		board.put(new Knight());
		
		System.out.println("-----------------");
		System.out.println(board);
		
		board.put(new Knight());
		
		System.out.println("-----------------");
		System.out.println(board);
		
		board.put(new Knight());
		
		System.out.println("-----------------");
		System.out.println(board);
		
		board.put(new Knight());
		
		System.out.println("-----------------");
		System.out.println(board);
		
		board.put(new Knight());
		
		System.out.println("-----------------");
		System.out.println(board);
	}

}
