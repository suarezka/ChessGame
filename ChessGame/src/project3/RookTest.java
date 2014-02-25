package project3;

import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;
import project3.Rook;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the {@code Rook} class
 * 
 * @author Dailynn Dietz 
 * @author Kaye Suarez
 */
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

}
