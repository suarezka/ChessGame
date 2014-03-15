package GUI;

import project3.Bishop;
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
	Player curPlayer;
	boolean gameInProgress;
	IChessPiece[][] board;
	
	
	public ChessModel() {
		//Create game board
		board = new IChessPiece[8][8];
		gameInProgress = true;
		
		//Set white pieces on board
		board[0][0] = new Rook(Player.WHITE);
		board[0][1] = new Knight(Player.WHITE);
		board[0][2] = new Bishop(Player.WHITE);
		board[0][3] = new Queen(Player.WHITE);
		board[0][4] = new King(Player.WHITE);
		board[0][5] = new Bishop(Player.WHITE);
		board[0][6] = new Knight(Player.WHITE);
		board[0][7] = new Rook(Player.WHITE);
		board[1][0] = new Pawn(Player.WHITE);
		board[1][1] = new Pawn(Player.WHITE);
		board[1][2] = new Pawn(Player.WHITE);
		board[1][3] = new Pawn(Player.WHITE);
		board[1][4] = new Pawn(Player.WHITE);
		board[1][5] = new Pawn(Player.WHITE);
		board[1][6] = new Pawn(Player.WHITE);
		board[1][7] = new Pawn(Player.WHITE);
		
		//Set black pieces on board
		board[7][0] = new Rook(Player.BLACK);
		board[7][1] = new Knight(Player.BLACK);
		board[7][2] = new Bishop(Player.BLACK);
		board[7][3] = new Queen(Player.BLACK);
		board[7][4] = new King(Player.BLACK);
		board[7][5] = new Bishop(Player.BLACK);
		board[7][6] = new Knight(Player.BLACK);
		board[7][7] = new Rook(Player.BLACK);
		board[6][0] = new Pawn(Player.BLACK);
		board[6][1] = new Pawn(Player.BLACK);
		board[6][2] = new Pawn(Player.BLACK);
		board[6][3] = new Pawn(Player.BLACK);
		board[6][4] = new Pawn(Player.BLACK);
		board[6][5] = new Pawn(Player.BLACK);
		board[6][6] = new Pawn(Player.BLACK);
		board[6][7] = new Pawn(Player.BLACK);
		
	}
	
	@Override
	public Player currentPlayer() {
		
		return null;
	}

	@Override
	public boolean inCheck() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComplete() {
		//TODO: King captured?
		return false;
	}

	@Override
	public boolean isValidMove(Move move) {
		return board[move.fromRow][move.fromColumn].isValidMove(move, board);
	}

	@Override
	public void move(Move move) {
		board[move.fromRow][move.fromColumn] = board[move.fromRow][move.fromColumn];
	}

	@Override
	public int numColumns() {
		return board[0].length;
	}

	@Override
	public int numRows() {
		return board.length;
	}

	@Override
	public IChessPiece pieceAt(int row, int col) {
		return board[row][col];
	}

}
