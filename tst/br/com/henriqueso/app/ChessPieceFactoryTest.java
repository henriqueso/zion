package br.com.henriqueso.app;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.henriqueso.zion.piece.*;


public class ChessPieceFactoryTest {

	@Test
	public void testCreate1King() throws InstantiationException, IllegalAccessException {
		List<ChessPiece> pieces = ChessPieceFactory.create(1, "K");
		
		Assert.assertEquals(King.class, pieces.get(0).getClass());
	}
	
	@Test
	public void testCreate1Queen() throws InstantiationException, IllegalAccessException {
		List<ChessPiece> pieces = ChessPieceFactory.create(1, "Q");
		
		Assert.assertEquals(Queen.class, pieces.get(0).getClass());
	}
	
	@Test
	public void testCreate1Bishop() throws InstantiationException, IllegalAccessException {
		List<ChessPiece> pieces = ChessPieceFactory.create(1, "B");
		
		Assert.assertEquals(Bishop.class, pieces.get(0).getClass());
	}
	
	@Test
	public void testCreate1Rook() throws InstantiationException, IllegalAccessException {
		List<ChessPiece> pieces = ChessPieceFactory.create(1, "R");
		
		Assert.assertEquals(Rook.class, pieces.get(0).getClass());
	}
	
	
	@Test
	public void testCreate1Knight() throws InstantiationException, IllegalAccessException {
		List<ChessPiece> pieces = ChessPieceFactory.create(1, "N");
		
		Assert.assertEquals(Knight.class, pieces.get(0).getClass());
	}

}
