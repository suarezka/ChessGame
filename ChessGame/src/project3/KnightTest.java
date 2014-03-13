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
	
	//TODO: Broken, un break
	@Test
	public void invalidMoves() throws Exception {
		int fromR = 3;
		int fromC = 5;
		
		board[fromR][fromC] = piece;
		
		//Arrays of proper moves
		int[] rMoves = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] cMoves = {1, 2, 2, 1, -1, -2, -2, -1};
		
		for(int k = 0; k < board.length; k++){
			for(int m = 0; m < board[0].length; m++){
				Move tempMove = new Move(fromR, fromC, k, m);
				for(int p = 0; p < rMoves.length; p++){
					if(rMoves[p] + fromR == k && cMoves[p] + fromC == m){
						assertTrue("Knight true loop test", 
								piece.isValidMove(tempMove, board));
					}else{
						assertFalse("Knight false loop test", 
								piece.isValidMove(tempMove, board));
					}
				}
			}
		}
	}
}
