package GUI;

import project3.ChessPiece;
import gvprojects.chess.model.IChessModel;
import gvprojects.chess.model.IChessPiece;
import gvprojects.chess.model.Move;
import gvprojects.chess.model.Player;

public class ChessModel implements IChessModel {
	
	//Instance Variables
	Player curPlayer;
	//Some Game status variable
	IChessPiece[][] board;
	IChessPiece rookB, rookB2, knightB, knightB2,
		bishopB, bishopB2, queenB, kingB,
		pawnB1, pawnB2, pawnB3, pawnB4,
		pawnB5, pawnB6, pawnB7, pawnB8;
	IChessPiece rookW, rookW2, knightW, knightW2,
		bishopW, bishopW2, queenW, kingW,
		pawnW1, pawnW2, pawnW3, pawnW4,
		pawnW5, pawnW6, pawnW7, pawnW8;
	
	
	public ChessModel() {
		//Create game board
		board = new IChessPiece[8][8];
		
		//Set up black pieces
		board[0][0] = rookB;
		board[0][1] = knightB;
		board[0][2] = bishopB;
		board[0][3] = queenB;
		board[0][4] = kingB;
		board[0][5] = bishopB2;
		board[0][6] = knightB2;
		board[0][7] = rookB2;
		board[1][0] = pawnB1;
		board[1][1] = pawnB2;
		board[1][2] = pawnB3;
		board[1][3] = pawnB4;
		board[1][4] = pawnB5;
		board[1][5] = pawnB6;
		board[1][6] = pawnB7;
		board[1][7] = pawnB8;
		
		//Set up white pieces
		board[0][0] = rookW;
		board[0][1] = knightW;
		board[0][2] = bishopW;
		board[0][3] = queenW;
		board[0][4] = kingW;
		board[0][5] = bishopW2;
		board[0][6] = knightW2;
		board[0][7] = rookW2;
		board[1][0] = pawnW1;
		board[1][1] = pawnW2;
		board[1][2] = pawnW3;
		board[1][3] = pawnW4;
		board[1][4] = pawnW5;
		board[1][5] = pawnW6;
		board[1][6] = pawnW7;
		board[1][7] = pawnW8;
	}
	@Override
	public Player currentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inCheck() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValidMove(Move arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move(Move arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public int numColumns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IChessPiece pieceAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
