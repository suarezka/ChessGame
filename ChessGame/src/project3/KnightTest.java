package project3;

import static org.junit.Assert.*;
import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

import org.junit.Test;

/************************************************************
 * CIS 163-07
 * Chess Project
 * JUnit Test for the knight chess piece class
 *
 * @author DaiLynn Dietz
 * @author Kaye Suarez
 * @version Mar 8, 2014
 ************************************************************/
public class KnightTest extends ChessPieceTest {

	@Override
	protected IChessPiece make(Player p) {
		return new Knight(p);
	}

	@Override
	protected Move getValidMove(int fromRow, int fromCol) {
		int toRow = fromRow + 1;
		int toCol = fromCol - 2;
		
		if(toRow >= board.length){
			toRow = fromRow - 1;
		}
		if(toCol < 0){
			toCol = fromCol + 2;
		}
		
		return new Move(fromRow, fromCol, toRow, toCol);
	}

	@Test
	public void canJumpPiece() throws Exception {
		IChessPiece otherPiece = make(Player.WHITE);
		
		board[0][0] = piece;
		board[0][1] = otherPiece;
		
		assertTrue("Knight Test 1", piece.isValidMove(
				new Move(0, 0, 2, 1), board));
	}
	
	@Test
	public void typeTest() throws Exception {
		assertEquals("Knight", piece.type());
	}
	
	@Test
	public void negativeMove() throws Exception {
		board[0][0] = piece;
		
		assertFalse("Knight Test 2", piece.isValidMove(
				new Move(0, 0, -1, 2), board));
	}
	
	@Test
	public void invalidMoves() throws Exception {
		//TODO Add loop that checks all spots on board for validity
	}
}
