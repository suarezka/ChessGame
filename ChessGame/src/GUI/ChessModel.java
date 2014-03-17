package GUI;

import java.awt.Point;
import java.util.ArrayList;

import project3.Bishop;
import project3.ChessPiece;
import project3.King;
import project3.Knight;
import project3.Pawn;
import project3.Queen;
import project3.Rook;
import gvprojects.chess.model.IChessModel;
import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

public class ChessModel implements IChessModel {
	
	//Instance Variables
	private Player curPlayer;
	private boolean gameInProgress;
	private IChessPiece[][] board;
	private ArrayList<Move> attackMovesB;
	private ArrayList<Move> attackMovesW;
	
	
	/************************************************************
	 * ChessModel constructor
	 ************************************************************/
	public ChessModel() {
		//Create game board
		board = new IChessPiece[8][8];
		curPlayer = Player.WHITE;
		gameInProgress = true;
		attackMovesB = new ArrayList<Move>();
		attackMovesW = new ArrayList<Move>();
		
		//Set black pieces on board
		board[0][0] = new Rook(Player.BLACK);
		board[0][1] = new Knight(Player.BLACK);
		board[0][2] = new Bishop(Player.BLACK);
		board[0][3] = new Queen(Player.BLACK);
		board[0][4] = new King(Player.BLACK);
		board[0][5] = new Bishop(Player.BLACK);
		board[0][6] = new Knight(Player.BLACK);
		board[0][7] = new Rook(Player.BLACK);
		board[1][0] = new Pawn(Player.BLACK);
		board[1][1] = new Pawn(Player.BLACK);
		board[1][2] = new Pawn(Player.BLACK);
		board[1][3] = new Pawn(Player.BLACK);
		board[1][4] = new Pawn(Player.BLACK);
		board[1][5] = new Pawn(Player.BLACK);
		board[1][6] = new Pawn(Player.BLACK);
		board[1][7] = new Pawn(Player.BLACK);
		
		//Set white pieces on board
		board[7][0] = new Rook(Player.WHITE);
		board[7][1] = new Knight(Player.WHITE);
		board[7][2] = new Bishop(Player.WHITE);
		board[7][3] = new Queen(Player.WHITE);
		board[7][4] = new King(Player.WHITE);
		board[7][5] = new Bishop(Player.WHITE);
		board[7][6] = new Knight(Player.WHITE);
		board[7][7] = new Rook(Player.WHITE);
		board[6][0] = new Pawn(Player.WHITE);
		board[6][1] = new Pawn(Player.WHITE);
		board[6][2] = new Pawn(Player.WHITE);
		board[6][3] = new Pawn(Player.WHITE);
		board[6][4] = new Pawn(Player.WHITE);
		board[6][5] = new Pawn(Player.WHITE);
		board[6][6] = new Pawn(Player.WHITE);
		board[6][7] = new Pawn(Player.WHITE);
		
	}
	
	/************************************************************
	 * Gives the current player in game
	 * 
	 * @return  Current Player
	 ************************************************************/
	@Override
	public Player currentPlayer() {
		return curPlayer;
	}

	/************************************************************
	 * Returns if the game is in check, regardless of color
	 * 
	 * @return  True if game is in check
	 ************************************************************/
	@Override
	public boolean inCheck() {
		boolean isInCheck = false;
		
		//Clearing arrayList to avoid
		attackMovesB.clear();
		attackMovesW.clear();
		
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board[0].length; c++){
				
				//Checks if piece at board is a king in check
				if(board[r][c].type().equals("King") && 
						((King) board[r][c]).isInCheck(r, c, board)){
					isInCheck = true;
					
					//Checks player color to fill appropriate array list
					if(board[r][c].player() == Player.BLACK){
						attackMovesB = ((King) board[r][c]).getAttackers();
					}else{
						attackMovesW = ((King) board[r][c]).getAttackers();
					}
				}
			}
		}
		return isInCheck;
	}

	/************************************************************
	 * Returns if there is a checkmate or not
	 * 
	 * @return True if there is a checkmate
	 ************************************************************/
	@Override
	public boolean isComplete() {
		
		//Checks if in check first, also as result fills
		//array lists of attackers
		if(!inCheck()){
			return false;
		}
		
		if(!attackMovesB.get(0).equals(null)){
			
		}
		
		return false;
	}
	

	/************************************************************
	 * Gets the path traveled by the attacking piece
	 * 
	 * @param move 
	 * @return  
	 ************************************************************/
	private ArrayList<Point> pathGetter(Move move){
		ArrayList<Point> path = new ArrayList<Point>();
		
		int toR = move.toRow;
		int toC = move.toColumn;
		int fromR = move.fromRow;
		int fromC = move.fromColumn;
		
		//Checking if the methods of ChessPiece can be used
		if(board[fromR][fromC].type().equals("Queen") ||
				board[fromR][fromC].type().equals("Rook") || 
				board[fromR][fromC].type().equals("Bishop")){
			
			board[fromR][fromC].isValidMove(move, board);
			path = ((ChessPiece) board[fromR][fromC]).getPiecePath();
		
		//Checking if piece has no path, and just needs to be removed to block
		}else if(board[fromR][fromC].type().equals("Pawn") 
				|| board[fromR][fromC].type().equals("Knight")){
			path.add(new Point(fromR, fromC));
		
		//Else case is for kings which dont attack.
		}else{
			path = null;
		}
	
		return path;
	}
	
	/************************************************************
	 * isValidMove for model, returns if  a move is valid
	 * 
	 * @param move Move being checked for validity
	 * @return  True if move is valid
	 ************************************************************/
	@Override
	public boolean isValidMove(Move move) {
		if(!board[move.fromRow][move.fromColumn].isValidMove(move, board)){
			return false;
		}
		
		if(inCheck() && Player.BLACK == curPlayer && !attackMovesB.isEmpty()){
			
		}else if(inCheck()){
			
		}
		
		return true;
	}

	/************************************************************
	 * Method to actually move pieces around on the board
	 * 
	 * @param move Desired move to be made
	 ************************************************************/
	@Override
	public void move(Move move) {
		if (!isValidMove(move)) {
			throw new IllegalArgumentException("Not a valid move");
		}
		
		board[move.toRow][move.toColumn] = board[move.fromRow][move.fromColumn];
		board[move.fromRow][move.fromColumn] = null;
		curPlayer.next();
	}

	/************************************************************
	 * Returns the number of columns in board[][]
	 * 
	 * @return  Length of board[0]
	 ************************************************************/
	@Override
	public int numColumns() {
		return board[0].length;
	}

	/************************************************************
	 * Returns the number of rows in board[][]
	 * 
	 * @return  Length of board
	 ************************************************************/
	@Override
	public int numRows() {
		return board.length;
	}

	/************************************************************
	 * returns piece at the given location on the board
	 * 
	 * @param row Row where piece is found
	 * @param col Column where piece is found
	 * @return  IChessPiece from the board at desired location
	 ************************************************************/
	@Override
	public IChessPiece pieceAt(int row, int col) {
		return board[row][col];
	}

}
