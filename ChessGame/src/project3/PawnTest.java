package project3;

import static org.junit.Assert.*;
import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

import org.junit.Test;

/************************************************************
 * CIS 163-07
 * Chess Project
 * JUnit Test for the Pawn Class
 *
 * @author DaiLynn Dietz
 * @author Kaye Suarez
 * @version Mar 8, 2014
 ************************************************************/
public class PawnTest extends ChessPieceTest {

	@Override
	protected IChessPiece make(Player p) {
		return new Pawn(p);
	}

	@Override
	protected Move getValidMove(int fromRow, int fromCol) {
		
		//Checks color of pawn because pawns only 
		//can move forward, not backwards
		if(piece.player() == Player.WHITE){
			return new Move(fromRow, fromCol, fromRow - 1, fromCol);
		}else{
			return new Move(fromRow, fromCol, fromRow + 1, fromCol);
		}
		//TODO figure out how to handle pawns at the end of the board
	}
	
	@Test
	public void typeTest() throws Exception {
		assertEquals("Pawn", piece.type());
	}
	
	@Test
	public void regularCaptureDown(){
		board[2][5] = piece;
		IChessPiece otherPiece = new Pawn(Player.BLACK);
		board[3][4] = otherPiece;
		Move capture = new Move(2, 5, 3, 4);
		assertTrue("Pawn Capture Down Test", piece.isValidMove(capture, board));
	}

}
