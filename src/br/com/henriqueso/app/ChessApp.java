package br.com.henriqueso.app;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.SerializationUtils;

import br.com.henriqueso.zion.board.ChessBoard;
import br.com.henriqueso.zion.board.Position;
import br.com.henriqueso.zion.exceptions.NoAvailablePositionException;
import br.com.henriqueso.zion.exceptions.ThreatenedPieceException;
import br.com.henriqueso.zion.piece.ChessPiece;
import br.com.henriqueso.zion.piece.ChessPieceComparator;

public class ChessApp {
	
	private static final int DIMENSION_PARAM = 0;
	private static final int PIECES_PARAM = 1;
	
	private static long boardCount = 0;

	private static Set<ChessBoard> uniqueBoards = new HashSet<>();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		int rows = getRows(args);
		int columns = getColumns(args);
		
		try {
			
			List<ChessPiece> pieces = getPieces(args);
			
			if (pieces != null) {
				Collections.sort(pieces, new ChessPieceComparator());
				
				ChessApp app = new ChessApp();
				app.addPieces(pieces, new ChessBoard(rows, columns));
				
				long end = System.currentTimeMillis();
				System.out.println(boardCount + " boards. Took " + (end - start) + " milliseconds.");
			}
			
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
				
	}

	private void addPieces(List<ChessPiece> pieces, ChessBoard board) {
		try {
			
			if ( !pieces.isEmpty() ) {
				ChessBoard chessBoard = null;
				Position next = null;
				
				Iterator<Position> iterator = board.getAvailablePositions().iterator();
				
				boolean found = false;
				while (iterator.hasNext() && !found) {
					
					
					next = iterator.next();
					
					chessBoard = SerializationUtils.clone(board);
					
					try {
						
						addPiece(pieces.get(0), next, chessBoard);
						
						if (pieces.size() > 1) {
							addPieces(pieces.subList(1, pieces.size()), chessBoard);
						} else {
							
							addIfNotExist(chessBoard);
														
							found = true;
						}
					} catch (NoAvailablePositionException | ThreatenedPieceException bex) {
//						System.out.println(Thread.currentThread().getName() + " not possible");
					}
				}
				
			}
		} catch (RuntimeException rex) {
			rex.printStackTrace();
		}
		
	}

	private void addIfNotExist(ChessBoard chessBoard) {
		if (!uniqueBoards.contains(chessBoard)) {
			uniqueBoards.add(chessBoard);
			
			boardCount++;

//			System.out.println(Thread.currentThread().getName() + "\n" + chessBoard);
		}

	}

	private void addPiece(ChessPiece piece, Position position, ChessBoard board) {
		try {

			board.put(piece, position);
			
		} catch (ThreatenedPieceException rex) {
			throw rex;
		}
		
		
	}
	
	private static List<ChessPiece> getPieces(String[] args) throws InstantiationException, IllegalAccessException {
		ArrayList<ChessPiece> pieces = null;
		
		if (args.length > PIECES_PARAM && args[PIECES_PARAM] != null) {
			pieces = new ArrayList<>();
			
			String[] piecesGroup = args[PIECES_PARAM].split(",");
			
			for (String pieceGroup : piecesGroup) {
				String amount = String.valueOf(pieceGroup.charAt(0));
				String pieceName = String.valueOf(pieceGroup.charAt(1));
				
				List<ChessPiece> piecesCreated = ChessPieceFactory.create(Integer.parseInt(amount), pieceName);
				
				pieces.addAll(piecesCreated);
			}
		}
		
		return pieces;
	}

	private static int getRows(String[] args) {
		int rows = 3;
		
		if (args.length > 0 && args[DIMENSION_PARAM] != null) {
			String[] dimension = args[0].split("x");
			rows = Integer.parseInt(dimension[0]);
		}

		return rows;
	}

	
	private static int getColumns(String[] args) {
		int columns = 3;
		
		if (args.length > 0 && args[0] != null) {
			String[] dimension = args[0].split("x");
			columns = Integer.parseInt(dimension[1]);
		}

		return columns;
	}

}