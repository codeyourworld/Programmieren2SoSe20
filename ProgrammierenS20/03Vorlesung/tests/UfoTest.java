package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufogame.Ufo;

class UfoTest {
	
	Ufo ufo;

	@BeforeAll
	static void begin() {
		System.out.println("@BeforeAll");
	}
	
	@BeforeEach
	void init() {
		System.out.println("beforeEach");
		ufo = new Ufo(100, 100, 50, 50, 3, "");
	}
	
	@AfterEach
	void afterMethods() {
		System.out.println("@AfterEach");
	}
	
	@AfterAll
	static void end() {
		System.out.println("AfterAll");
	}
	
	@Test
	void testMove() {
		System.out.println("TestMove");
		ufo.move();
		assertEquals(103, ufo.getX());
	}
	
	@Test
	void testBla() {
		System.out.println("testBla");
	}


}
