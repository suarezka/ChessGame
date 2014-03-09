package project3;

import static org.junit.Assert.*;
import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

import org.junit.Test;

/************************************************************
 * CIS 163-07
 * Chess Project
 * JUnit Test for the King Class
 *
 * @author DaiLynn Dietz
 * @author Kaye Suarez
 * @version Mar 8, 2014
 ************************************************************/
public class KingTest extends ChessPieceTest {

	@Override
	protected IChessPiece make(Player p) {
		return new King(p);
	}

	@Override
	protected Move getValidMove(int fromRow, int fromCol) {
		
		int newRow = fromRow + 1;
	      if (newRow >= board.length) {
	         newRow = fromRow - 1;
	      }
	      return new Move(fromRow, fromCol, newRow, fromCol);
	}
	
	@Test
	public void typeTest() throws Exception {
		assertEquals("King", piece.type());
	}

}
