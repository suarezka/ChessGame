package project3;

import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

/************************************************************
 * CIS 163-07
 * Chess Project
 * Parent class to all other chess piece classes
 *
 * @author Kaye Suarez
 * @author DaiLynn Dietz
 * @version Feb 24, 2014
 ************************************************************/
public abstract class ChessPiece implements IChessPiece {
	
	/** Owner of the ChessPiece */
	private Player owner;
	
	/************************************************************
	 * Constructor for ChessPiece
	 * 
	 * @param p Player that owns this piece
	 ************************************************************/
	protected ChessPiece (Player p) {
		owner = p;
	}
	
	/************************************************************
	 * Abstract method that determines if a move is valid or not
	 * for the most general case
	 * 
	 * @param move The move to be taken by the piece
	 * @param board The game board occupied with chess pieces
	 * @return  true if move is valid
	 ************************************************************/
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		
		//Gathering move data
		int fromC = move.fromColumn;
		int fromR = move.fromRow;
		int toC = move.toColumn;
		int toR = move.toRow;
		
		//Makes sure a move is happening
		if(toC == fromC && toR == fromR)
			return false;
		
		//TODO: This code makes the test cases to not work so need to rework it
		//Checking if destination is occupied by same team
		//if(board[toR][toC].player() == owner)
			//return false;
		
		//Ensuring that the piece is at the from location
		if(board[fromR][fromC] != this)
			return false;
		
		return true;
	}

	/************************************************************
	 * Returns the current owner of the piece in question
	 * 
	 * @return  Owner team of the ChessPiece
	 ************************************************************/
	@Override
	public Player player() {
		return owner;
	}

	/************************************************************
	 * Abstract method that returns the type of piece made
	 * 
	 * @return  Type of piece (rook, bishop, king etc)
	 ************************************************************/
	@Override
	public abstract String type();
	
	//TODO: Make public method to decide which private to use
	public boolean isPathClear(int fromR, int fromC, int toR, 
			int toC, IChessPiece board[][]) {
		
		//Piece is moving horizontal or vertical
		if (fromR == toR || fromC == toC) {
			return isPathClearHorizontal(fromR, fromC, toR, toC, board);
		} else {
			return isPathClearDiagonal(fromR, fromC, toR, toC, board);
		}
	}

	/************************************************************
	 * Method that will check if path is clear for piece to move.
	 * @param fromR Starting row
	 * @param fromC Starting column
	 * @param toR Ending row
	 * @param toC Ending Column
	 * @param board Board being played on
	 * @return  True if path between points is clear of pieces
	 ************************************************************/
	private boolean isPathClearHorizontal(int fromR, int fromC, int toR, 
			int toC, IChessPiece board[][]) {
		
		int start;
		int end;
		
		/* Check horizontal path */
		if (fromR == toR) {
			
			//Can check either left or right
			if (fromC > toC) {
				start = toC;
				end = fromC - 1;
			} else {
				start = fromC + 1;
				end = toC;
			}
			
			//Loop through horizontal path 
			while (start < end) {
				if (board[fromR][start] != null) {
					return false;
				}
				
				start++;
			}
		
		/* Check vertical path */
		} else { 
			
			//Can check up and down
			if (fromR > toR) {
				start = toR;
				end = fromR - 1;
			} else {
				start = fromR + 1;
				end = toR;
			}
			
			while (start <= end) {
				if (board[start][fromC] != null) {
					return false;
				}
				
				start++;
			}
		}
		
		return true;
	}
	
	/************************************************************
	 * Method to check if diagonal path is clear for piece to move.
	 * @param fromR Starting row
	 * @param fromC Starting column
	 * @param toR Ending row
	 * @param toC Ending Column
	 * @param board Board being played on
	 * @return  True if path between points is clear of pieces
	 ************************************************************/
	private boolean isPathClearDiagonal(int fromR, int fromC, int toR, 
			int toC, IChessPiece board[][]) {
		
		/* Checks diagonal paths */
		int startR;
		int startC;
		
		//Checks diagonal up
		if (fromR > toR) {
			
			startR = fromR - 1;
			
			//Check left up
			if (fromC > toC) {
				startC = fromC - 1;
				
				while (startR != toR && startC != toC) {
					if (board[startR][startC] != null) {
						return false;
					}
					
					startR--;
					startC--;
				}
			
			//Checks right up
			} else {
				startC = fromC + 1;
				
				while (startR != toR && startC != toC) {
					if (board[startR][startC] != null) {
						return false;
					}
					
					startR--;
					startC++;
				}
			}
			
		//Checks diagonal down	
		} else {
			
			startR = fromR + 1;
			
			//Checks left down
			if (fromR < toR) {
				startC = fromC - 1;
				
				while (startR != toR && startC != toC) {
					if (board[startR][startC] != null) {
						return false;
					}
					
					startR++;
					startC--;
				} 
				
			//Checks right down
			} else {
				startC = fromC + 1;
				
				while (startR != toR && startC != toC) {
					if (board[startR][startC] != null) {
						return false;
					}
					
					startR++;
					startC++;
				}
			}
			
		}
		
		return true;
	}
}
