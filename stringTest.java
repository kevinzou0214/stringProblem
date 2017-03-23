package com.apple.itunes;

import static org.junit.Assert.*;

import org.junit.Test;

public class stringTest {
	@Test
	public void test1() throws Exception {
		String inputString = "test";
		String expectedResult = "es";
		String actaulResult = solution.removeChar(inputString, 't');
		assertEquals(actaulResult, expectedResult);
	}
	@Test
	public void test2() throws Exception {
		String inputString = "test";
		String expectedResult = "es";
		String actaulResult = solution.removeCharOneLine(inputString, 't');
		assertEquals(actaulResult, expectedResult);
	}
	@Test
	public void test3() throws Exception {
		String inputString = "test ";
		String expectedResult = "test ";
		String actaulResult = solution.removeChar(inputString, 'p');
		assertEquals(actaulResult, expectedResult);
	}
	@Test
	public void test4() throws Exception {
		String inputString = "test ";
		String expectedResult = "test";
		String actaulResult = solution.removeChar(inputString, ' ');
		assertEquals(actaulResult, expectedResult);
	}
	@Test
	public void test5() throws Exception {
		String inputString = null;
		String expectedResult = null;
		String actaulResult = solution.removeChar(inputString, 't');
		assertEquals(actaulResult, expectedResult);
	}
}
