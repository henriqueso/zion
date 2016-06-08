package br.com.henriqueso.zion.piece;

import java.util.ArrayList;
import java.util.List;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;

public class Bishop extends ChessPiece {

	public Bishop() {
		setName("B");
	}
	
	@Override
	public List<Position> threatens(ChessBoard chessBoard, Position position) {
		List<Position> threatened = new ArrayList<>();
		
		southEast(chessBoard, threatened, position, true);
		southWest(chessBoard, threatened, position, true);
		northWest(chessBoard, threatened, position, true);
		northEast(chessBoard, threatened, position, true);
		
		return threatened;
	}

	@Override
	public Integer getThreatLevel() {
		return Integer.valueOf(4);
	}

	private static final long serialVersionUID = 1L;
}
