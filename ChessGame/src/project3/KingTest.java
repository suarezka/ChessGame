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

	@Test
	public void inCheck() throws Exception {
		board[0][0] = piece;
		board[0][1] = new Rook(piece.player().next());
		
		assertTrue("inCheck Test", ((King) piece).isInCheck(0,0,board));
	}
	
	@Test
	public void notInCheck() throws Exception {
		board[0][0] = piece;
		board[0][1] = new Bishop(piece.player().next());
		
		assertFalse("Not inCheck Test", ((King) piece).isInCheck(0, 0, board));
	}
	
	@Test
	public void canMoveRight() throws Exception {
		board[0][0] = piece;
		Move move = new Move(0, 0, 0, 1);
		
		assertTrue("King Move Right", piece.isValidMove(move, board));
	}
	
	@Test
	public void canMoveLeft() throws Exception {
		board[7][7] = piece;
		Move move = new Move(7, 7, 7, 6);
		
		assertTrue("King Move Left", piece.isValidMove(move, board));
	}
	
	@Test
	public void canMoveUp() throws Exception {
		board[7][7] = piece;
		Move move = new Move(7, 7, 6, 7);
		
		assertTrue("King Move Up", piece.isValidMove(move, board));
	}
	
	@Test
	public void canMoveDown() throws Exception {
		board[0][0] = piece;
		Move move = new Move(0, 0, 1, 0);
		
		assertTrue("King Move Down", piece.isValidMove(move, board));
	}
	
	@Test
	public void canMoveRightDown() throws Exception {
		board[0][0] = piece;
		Move move = new Move(0, 0, 1, 1);
		
		assertTrue("King DownRight Move", piece.isValidMove(move, board));
	}
	
	@Test
	public void canMoveDownLeft() throws Exception {
		board[0][7] = piece;
		Move move = new Move(0, 7, 1, 6);
		
		assertTrue("King DownLeft Move", piece.isValidMove(move, board));
	}
	
	@Test
	public void canMoveRightUp() throws Exception {
		board[7][0] = piece;
		Move move = new Move(7, 0, 6, 1);
		
		assertTrue("King UpRight Move", piece.isValidMove(move, board));
	}
	
	@Test
	public void canMoveLeftUp() throws Exception {
		board[7][7] = piece;
		Move move = new Move(7, 7, 6, 6);
		
		assertTrue("King LeftUp Move", piece.isValidMove(move, board));
	}
	
	@Test
	public void doesntMoveToCheck() throws Exception {
		board[4][2] = piece;
		board[2][5] = new Bishop(piece.player().next());
		
		assertFalse("King doesnt move to check test", 
				piece.isValidMove(new Move(4 ,2, 4, 3), board));
	}
	
	
	//TODO made an oopsy here
	@Test
	public void cantAttackOtherKing() throws Exception {
		board[6][2] = piece;
		board[6][4] = new King(piece.player().next());
		
		assertFalse("Kings Dont Attack", piece.isValidMove(new Move(6, 2, 6, 3), board));
	}
}
