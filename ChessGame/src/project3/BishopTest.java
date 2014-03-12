package project3;

import static org.junit.Assert.*;
import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

import org.junit.Test;

/************************************************************
 * CIS 163-07
 * Chess Project
 * JUnit Test for the Bishop Class
 *
 * @author DaiLynn Dietz
 * @author Kaye Suarez
 * @version Mar 8, 2014
 ************************************************************/
public class BishopTest extends ChessPieceTest {

	@Override
	protected IChessPiece make(Player p) {
		return new Bishop(p);
	}

	@Override
	protected Move getValidMove(int fromRow, int fromCol) {
		int toRow = fromRow + 1;
		int toCol = fromCol + 1;
		
		if(toRow > board.length){
			toRow = fromRow - 1;
		}
		if(toCol > board[0].length){
			toCol = fromCol - 1;
		}
		
		return new Move(fromRow, fromCol, toRow, toCol);
	}
	
	@Test
	public void typeTest() throws Exception {
		assertEquals("Bishop", piece.type());
	}
	
	@Test
	   public void canMoveInRDownDiagonal() throws Exception {
	      board[1][1] = piece;
	      Move bishopDRight = new Move(1,1,3,3);
	      assertTrue("Bishop RightDown Diagonal Test", piece.isValidMove(bishopDRight, board));
	   }
	
	@Test
	   public void canMoveInRUpDiagonal() throws Exception {
	      board[3][3] = piece;
	      Move bishopUpRight = new Move(3,3,1,5);
	      assertTrue("Bishop RightUp Diagonal Test", piece.isValidMove(bishopUpRight, board));
	   }
}
