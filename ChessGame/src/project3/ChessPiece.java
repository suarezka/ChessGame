package project3;

import java.awt.Point;
import java.util.ArrayList;

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
	
	/** Array List of latest path */
	private ArrayList<Point> path;

	/************************************************************
	 * Constructor for ChessPiece
	 * 
	 * @param p Player that owns this piece
	 ************************************************************/
	public ChessPiece (Player p) {
		owner = p;
		path = new ArrayList<Point>();
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

		try{

			//Gathering move data
			int fromC = move.fromColumn;
			int fromR = move.fromRow;
			int toC = move.toColumn;
			int toR = move.toRow;

			//Makes sure a move is happening
			if(toC == fromC && toR == fromR)
				return false;

			//Check if from location has piece
			if (board[fromR][fromC] == null) {
				throw new IllegalArgumentException ("No piece is there.");
			}

			//Checking if destination is occupied by same team
			if(board[toR][toC] != null && board[toR][toC].player() == owner)
				return false;

			//Ensuring that the piece is at the from location
			if(board[fromR][fromC] != this) {
				throw new IllegalArgumentException("Not expected piece.");
			}

			return true;

		}catch (IndexOutOfBoundsException e){
			return false;
		}
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


	/************************************************************
	 * Public method that determines which private method to use
	 * to check if the path is clear.
	 *
	 * @param fromR
	 * @param fromC
	 * @param toR
	 * @param toC
	 * @param board
	 * @return
	 ************************************************************/
	public boolean isPathClear(int fromR, int fromC, int toR, 
			int toC, IChessPiece board[][]) {

		//Piece is moving horizontal or vertical
		if (fromR == toR ^ fromC == toC) {
			return isPathClearHorizontal(fromR, fromC, toR, toC, board);
		} else {
			return isPathClearDiagonal(fromR, fromC, toR, toC, board);
		}
	}

	/************************************************************
	 * Method that will check if path is clear for piece to move.
	 * 
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
		path.clear();
		
		/* Check horizontal path */
		if (fromR == toR) {

			//Can check either left or right
			if (fromC > toC) {
				
				//Plus one to not check end, minus one to not check start
				start = toC + 1;
				end = fromC - 1;
			} else {
				start = fromC + 1;
				end = toC - 1;
			}

			//Loop through horizontal path 
			while (start <= end) {
				if (board[fromR][start] != null) {
					return false;
				}
				Point point = new Point(fromR, start);
				path.add(point);
				start++;
			}

			/* Check vertical path */
		} else { 

			//Can check up and down
			if (fromR > toR) {
				start = toR + 1;
				end = fromR - 1;
			} else {
				start = fromR + 1;
				end = toR - 1;
			}

			while (start <= end) {
				if (board[start][fromC] != null) {
					return false;
				}
				Point point = new Point(start, fromC);
				path.add(point);
				start++;
			}
		}

		return true;
	}

	/************************************************************
	 * Method to check if diagonal path is clear for piece to move.
	 * 
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
					Point point = new Point(startR, startC);
					path.add(point);
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
					Point point = new Point(startR, startC);
					path.add(point);
					startR--;
					startC++;
				}
			}

			//Checks diagonal down	
		} else {

			startR = fromR + 1;

			//Checks left down
			if (fromR > toR) {
				startC = fromC - 1;

				while (startR != toR && startC != toC) {
					if (board[startR][startC] != null) {
						return false;
					}
					Point point = new Point(startR, startC);
					path.add(point);
					startR++;
					startC--;
				} 

				//Checks right down
			} else {
				startC = fromC + 1;

				while (startR < toR && startC < toC) {
					if (board[startR][startC] != null) {
						return false;
					}
					Point point = new Point(startR, startC);
					path.add(point);
					startR++;
					startC++;
				}
			}

		}

		return true;
	}
	
	/************************************************************
	 * Returns true when a piece can "check" the other players king
	 * 
	 * @param piece Piece that may be able to check
	 * @param board Board being played on
	 * @param row Start row of the piece trying to check
	 * @param col Start col of the piece trying to check
	 * @return  True if piece can check other players king
	 ************************************************************/
	public boolean canCheck(IChessPiece piece, IChessPiece[][] board, int row, int col){
		
		//Loops through board
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board[0].length; c++){
				Move move = new Move(row, col , r, c);
				IChessPiece otherPiece = null;
				Player otherPlayer = null;
				
				//Stores piece and info
				if(board[r][c] != null){
					otherPiece = board[r][c];
					otherPlayer = otherPiece.player();
				}else{
					continue;
				}
				
				//Returns true when there is a valid
				//move to a king of other color
				if(piece.isValidMove(move, board) && (otherPiece.type())
						.equals("King") && otherPlayer != piece.player()){
					return true;
				}
			}
		}
		
		return false;
	}

	/************************************************************
	 * Returns the path for the piece 
	 * @return  Array list of points that represent path of piece
	 ************************************************************/
	public ArrayList<Point> getPiecePath(){
		return path;
	}
}
