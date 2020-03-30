package tests;

import static org.junit.jupiter.api.Assertions.*;
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
	@MethodSource("generateInteger")
	void testInt2ReturnTrue(int value) {
		assertEquals(2, value);
	}
	
	
	
	
	@Test
	void testReturnTrueMinion() {
		String name = "Minion";
		assertEquals("Minion", name);
		
	}
}
