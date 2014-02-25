package project3;

import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

/************************************************************
 * CIS 163-07
 * Project 0
 *
 * @version Feb 24, 2014
 ************************************************************/
public abstract class ChessPiece implements IChessPiece {
	private Player owner;
	
	protected ChessPiece (Player p) {
		owner = p;
	}
	
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player player() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public abstract String type();

}
