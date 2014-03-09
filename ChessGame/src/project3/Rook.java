package project3;

import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

/************************************************************
 * CIS 163-07
 * Chess Project
 * Class that controls the rook chess piece behavior
 *
 * @author DaiLynn Dietz
 * @author Kaye Suarez
 * @version Mar 8, 2014
 ************************************************************/
public class Rook extends ChessPiece {

	/************************************************************
	 * Constructor for the rook class
	 * 
	 * @param p Player to be owning this rook
	 ************************************************************/
	protected Rook(Player p) {
		super(p);
	}

	/************************************************************
	 * Returns the type of this piece, "Rook"
	 *  
	 * @return  String word that describes type of piece (rook)
	 ************************************************************/
	@Override
	public String type() {
		return "Rook";
	}

	/************************************************************
	 * Determines if a rook can make the desired move
	 * 
	 * @param move Move desired to be made by rook
	 * @return  True if is valid move
	 ************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board){

		//Getting move data for Rook piece
		int fromC = move.fromColumn;
		int fromR = move.fromRow;
		int toC = move.toColumn;
		int toR = move.toRow;

		//Parent isValidMove method
		if(!super.isValidMove(move, board)){
			return false;
		}


		//Check if move is either front/back or side to side
		if (fromC != toC || fromR != toR) {
			return false;
		}

		if(!isPathClear(fromR, fromC, toR, toC, board)){
			return false;
		}

		return true;
	}

	/************************************************************
	 * Helper method to allow queen to use same logic
	 * 
	 * @param fromR Starting row
	 * @param fromC Starting column
	 * @param toR Ending row
	 * @param toC Ending Column
	 * @param board Board being played on
	 * @return  True if path between points is clear of pieces
	 ************************************************************/
	public static boolean isPathClear(int fromR, int fromC, int toR, 
			int toC, IChessPiece[][] board){

		int start;
		int end;

		//Check if other pieces in path going horizontal
		if (fromR == toR) {

			//Makes it so left/right doesnt matter
			//The plus one prevents checks at the starting location
			if(fromC > toC){
				start = toC + 1;
				end = fromC;
			}else{
				start = fromC + 1;
				end = toC;
			}

			//Loop through path to see if piece is in the way
			while (start < end) {
				if (board[start][fromR] != null) {
					return false;
				}
				start++;
			}

			//Checks if other pieces in path going vertical
		}else{

			//Makes it so left/right doesnt matter
			if(fromR > toR){
				start = toR + 1;
				end = fromR;
			}else{
				start = fromR + 1;
				end = toR;
			}

			//Loops through path to see if piece is in way
			while(start < end){
				if(board[fromC][start] != null){
					return false;
				}
				start++;
			}
		}
		return true;
	}

}