package project3;

import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;
import project3.Rook;

import org.junit.Test;

import static org.junit.Assert.*;

/************************************************************
 * CIS 163-07
 * Chess Project 
 * JUnit Test for the Rook class
 * 
 * @author DaiLynn Dietz 
 * @author Kaye Suarez
 * @author Zachary Kurmas & Hans Dulimarta
 ***********************************************************/
// Created 12/8/12 at 9:01 PM
// (C) Zachary Kurmas 2012

public class RookTest extends ChessPieceTest {

   protected IChessPiece make(Player p) {
      return new Rook(p);
   }

   @Override
   protected Move getValidMove(int row, int col) {
      int newRow = row + 1;
      if (newRow >= board.length) {
         newRow = row - 1;
      }
      return new Move(row, col, newRow, col);
   }

   @Test
   public void canMoveInRight() throws Exception {
      board[1][1] = piece;
      assertTrue("Rook Test 1", piece.isValidMove(new Move(1, 1, 1, 6), board));
   }

   @Test
   public void canMoveInLeft() throws Exception {
      board[4][4] = piece;
      assertTrue("Rook Test 1", piece.isValidMove(new Move(4, 4, 4, 1), board));
   }
   
   @Test
   public void canMoveUp() throws Exception {
	   board[5][5] = piece;
	   assertTrue("Rook Test 1", piece.isValidMove(new Move(5,5,2,5), board));
   }

   @Test
   public void canMoveDown() throws Exception {
	   board[1][1] = piece;
	   assertTrue("Rook Test 1", piece.isValidMove(new Move(1,1,5,1),  board));
   }
   
   @Test
   public void isRook() throws Exception {
	   assertEquals("Rook Test 1", piece.type().equals("Rook"));
   }
   
   @Test
   public void checkInvalidMoves() throws Exception {
	   final int startRow = 3;
	   final int startCol = 3;
	   
	   board[startRow][startCol] = piece;
	   
	   //Looping through entire board and trying to move piece there
	   for(int row = 0; row < board.length; row++){
		   for(int col = 0; col < board[0].length; col++){
			   
			   boolean canMove = piece.isValidMove(
					   new Move(startRow, startCol, row, col), board);
			   
			   //Ensures piece can move in straight line
			   //Uses exclusive or operator (^) to make sure piece isnt 
			   //tested at start location
			   if(row == startRow ^ col == startCol){
				   assertTrue(canMove);
				   
			    //Ensures piece cant move other directions
			   }else{
				   assertFalse(canMove);
			   }
		   }
	   }
   }
   
   @Test
   public void pieceInWayRight() throws Exception {
	   IChessPiece otherPiece = make(Player.WHITE);
	   
	   board[0][0] = piece;
	   board[0][3] = otherPiece;
	   
	   assertFalse("Rook pieceInTheWay Test 1", piece.isValidMove(
			   new Move(0, 0, 0, 4), board));
   }
   
   @Test
   public void pieceInWayLeft() throws Exception {
	   IChessPiece otherPiece = make(Player.WHITE);
	   
	   board[6][4] = piece;
	   board[6][2] = otherPiece;
	   
	   assertFalse("Rook pieceInTheWay Test 2", piece.isValidMove(
			   new Move(6, 4, 6, 1), board));
   }
   
   @Test
   public void pieceInWayUp() throws Exception {
	   IChessPiece otherPiece = make(Player.WHITE);
	   
	   board[5][2] = piece;
	   board[4][2] = otherPiece;
	   
	   assertFalse("Rook pieceInTheWay Test 3", piece.isValidMove(
			   new Move(5, 2, 3, 2), board));
   }
   
   @Test
   public void pieceInWayDown() throws Exception {
	   IChessPiece otherPiece = make(Player.WHITE);
	   
	   board[2][3] = piece;
	   board[4][3] = otherPiece;
	   
	   assertFalse("Rook pieceInTheWay Test 4", piece.isValidMove(
			   new Move(2, 3, 4, 3), board));
   }
   
   @Test
   public void pieceOutOfWayHorizontal() throws Exception {
	   IChessPiece otherPiece = make(Player.WHITE);
	   
	   board[3][3] = piece;
	   board[3][5] = otherPiece;
	   
	   assertTrue("Rook pieceOutOfWay Test 1", piece.isValidMove(
			   new Move(3, 3, 3, 4), board));
   }
   
   @Test
   public void pieceOutOfWayVertical() throws Exception {
	   IChessPiece otherPiece = make(Player.WHITE);
	   
	   board[2][2] = piece;
	   board[5][2] = otherPiece;
	   
	   assertTrue("Rook pieceOutOfWay Test 2", piece.isValidMove(
			   new Move(2, 2, 4, 2), board));
   }
   
}
