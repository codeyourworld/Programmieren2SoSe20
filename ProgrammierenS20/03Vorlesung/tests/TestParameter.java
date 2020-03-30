package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


class TestParameter {

	@ParameterizedTest
	@MethodSource
	void test(String arg) {
		assertEquals("Minion", arg);
	}

	
	static Stream<String> test() {
		return Stream.of("test", "Minion", "Apple", "Pokemon");
	}
	
	
	@ParameterizedTest
	@MethodSource
	void testInteger(int value) {
		assertEquals(2, value);
	}
	
//	static Stream<Integer> testInteger() {
//		return Stream.of(2, 3, 4, 5, 6, 7, 99);
//	}

	//zahlen von 0 - 68
	//zahl * zahl soll durch 4 teilbar sein
	static IntStream testInteger() {
		return IntStream.range(0, 69).filter(x -> (x * x) % 4 == 0);
	}

	
	@Test
	void testReturnTrueMinion() {
		String name = "Minion";
		assertEquals("Minion", name);
		
	}
}
