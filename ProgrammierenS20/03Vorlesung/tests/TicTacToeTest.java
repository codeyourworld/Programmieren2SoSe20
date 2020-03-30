package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TicTacToeTest {

//	[0],[0]
//	[0],[1]
//	[0],[2]
	@ParameterizedTest
	@MethodSource
	void test(char symbol, int[] col, int[] row) {
		TicTacToe ttt = new TicTacToe();
		
		for(int i = 0; i < col.length; i++) {
			assertTrue(ttt.setSymbol(symbol, col[i], row[i]));
		}
		assertTrue(ttt.checkWinConditions(symbol));

	}
	
	static Stream<Arguments> test(){
		return Stream.of(
				Arguments.of(TicTacToe.X, new int[] {0, 0, 0}, new int[] {0, 1, 2}),
				Arguments.of(TicTacToe.X, new int[] {1, 1, 1}, new int[] {0, 1, 2}),
				Arguments.of(TicTacToe.X, new int[] {2, 2, 2}, new int[] {0, 1, 2}),
				Arguments.of(TicTacToe.X, new int[] {0, 1, 2}, new int[] {0, 0, 0}),
				Arguments.of(TicTacToe.X, new int[] {0, 1, 2}, new int[] {1, 1, 1}),
				Arguments.of(TicTacToe.X, new int[] {0, 1, 2}, new int[] {2, 2, 2}),
				Arguments.of(TicTacToe.X, new int[] {0, 1, 2}, new int[] {0, 1, 2}),
				Arguments.of(TicTacToe.X, new int[] {0, 1, 2}, new int[] {2, 1, 0})
				);
				
	}
	

}
