package br.com.henriqueso.zion.piece;

import java.util.Comparator;

public class ChessPieceComparator implements Comparator<ChessPiece> {

	@Override
	public int compare(ChessPiece piece1, ChessPiece piece2) {
		return piece2.getThreatLevel().compareTo(piece1.getThreatLevel());
	}

}
