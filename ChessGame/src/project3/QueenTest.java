package project3;

import static org.junit.Assert.*;
import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

import org.junit.Test;

/************************************************************
 * CIS 163-07
 * Chess Project 
 * JUnit Test for the Queen Class
 *
 * @author DaiLynn Dietz
 * @author Kaye Suarez
 * @version Mar 8, 2014
 ************************************************************/
public class QueenTest extends ChessPieceTest {

	@Override
	protected IChessPiece make(Player p) {
		return new Queen(p);
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
	public void canMoveRightShort() throws Exception {
		board[0][0] = piece;
		
		assertTrue("Queen Test 1", piece.isValidMove(
				new Move(0, 0, 0, 1), board));
	}
	
	@Test
	public void canMoveRightLong() throws Exception {
		board[0][0] = piece;
		
		assertTrue("Queen Test 2", piece.isValidMove(
				new Move(0, 0, 0, 6), board));
	}
	
	@Test
	public void typeTest() throws Exception {
		assertEquals("Queen", piece.type());
	}
}
