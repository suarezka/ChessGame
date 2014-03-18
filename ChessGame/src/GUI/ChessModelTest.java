package GUI;

import static org.junit.Assert.*;
import gvprojects.chess.model.IChessModel;
import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

import org.junit.Before;
import org.junit.Test;

import project3.*;

public class ChessModelTest {

	protected IChessModel model;
	
	@Before
	public void setup(){
		model = new ChessModel();
	}
	
	@Test
	public void isNotCompleteTest() throws Exception {
		assertFalse("Testing notIsComplete", model.isComplete());
	}

	@Test
	public void isCompleteTest() throws Exception {
		model.move(new Move(6, 5, 5, 5));
		model.move(new Move(1, 4, 2, 4));
		model.move(new Move(6, 6, 4, 6));
		model.move(new Move(0, 3, 4, 7));
		
		assertTrue(model.inCheck());
		assertTrue("Testing isComplete", model.isComplete());
	}
	
}
