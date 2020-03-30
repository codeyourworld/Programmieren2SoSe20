package tests;

public class TicTacToe {
	
	private char [][] field = new char[3][3];
	public static final char X = 'x';
	public static final char O = 'o';
	public static final char EMPTY = ' ';
	private char playersTurn;
	
	public TicTacToe() {
		
	}
	
	public boolean setSymbol(char symbol, int col, int row) {
		if(col < 3 && row < 3 && col >= 0 && row >= 0) {
			if(symbol == X || symbol == O) {
				if(field[col][row] == EMPTY) {
					field[col][row] = symbol;
					return true;
				}
			}			
		}
		return false;
	}
	
	public boolean checkWinConditions() {
		//Spalte und Zeile und diagonales checken
	}
	
	public boolean gameEnd() {
		for(int col = 0; col < field.length; col++) {
			for(int row = 0; row < field[0].length; row++) {
				if(field[col][row] == EMPTY) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void changePlayer() {
		if(playersTurn == X) {
			playersTurn = O;
		} 
		else {
			playersTurn = X;
		}
	}
	
	public char[][] getField() {
		return field;
	}
	
	
	
	public static void main(String[] args) {
		new TicTacToe();
	}
}
