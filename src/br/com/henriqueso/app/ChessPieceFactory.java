package br.com.henriqueso.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.henriqueso.zion.piece.*;

public class ChessPieceFactory {
	
	private static HashMap<String, Class> pieceTypes;

	static {
		pieceTypes = new HashMap<>();
		pieceTypes.put("K", King.class);
		pieceTypes.put("Q", Queen.class);
		pieceTypes.put("B", Bishop.class);
		pieceTypes.put("R", Rook.class);
		pieceTypes.put("N", Knight.class);
	}

	public static List<ChessPiece> create(int amount, String pieceName) throws InstantiationException, IllegalAccessException {
		List<ChessPiece> pieces = new ArrayList<>();
		
		for (int index = 0; index < amount; index++) {
			ChessPiece piece = create(pieceName);
			
			pieces.add(piece);
		}
		
		return pieces;
	}

	private static ChessPiece create(String pieceName) throws InstantiationException, IllegalAccessException {
		
		Class<ChessPiece> clazz = pieceTypes.get(pieceName);
		if (clazz != null) {
			return clazz.newInstance();
		}
		return null;
	}

}
