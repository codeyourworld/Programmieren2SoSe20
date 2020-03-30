package tests;

public class TicTacToe {
	
	private char [][] field = new char[3][3];
	public static final char X = 'x';
	public static final char O = 'o';
	public static final char EMPTY = '\u0000';
	private char playersTurn;
	
	public TicTacToe() {
		
	}
	
	public boolean setSymbol(char symbol, int col, int row) {
		if(col < 3 && row < 3 && col >= 0 && row >= 0) {
			if(symbol == X || symbol == O) {
				if(field[col][row] == EMPTY) {
					field[col][row] = symbol;
					return true;
				} else {
					System.out.println("field is not empty." + field[col][row] + ".");
				}
			}			
		}
		return false;
	}
	
	public boolean checkWinConditions(char symbol) {
		for(int col = 0; col < field.length; col++) {
			if(field[col][0] == field[col][1] && field[col][1] == field[col][2] && field[col][2] == symbol) {
				return true;
			}
		}
		
		for(int row = 0; row < field[0].length; row++) {
			if(field[0][row] == field[1][row] && field[1][row] == field[2][row] && field[0][row] == symbol) {
				return true;
			}
		}
		
		if(field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[2][2] == symbol) {
			return true;
		}
		
		if(field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[2][0] == symbol) {
			return true;
		}
		
		return false;
		
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
