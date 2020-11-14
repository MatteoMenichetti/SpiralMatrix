package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import spiral.SpiralMatrix;

public class SpiralMatrixTests {
	SpiralMatrix sm;
	int[][] m, t;

	@Test
	public void test2same2() {
		sm = new SpiralMatrix(2);
		m = sm.calculate();
		t = new int[][] { { 1, 2 }, { 4, 3 } };
		assertTrue(m[0].length == t[0].length && m.length == t.length && cycle(m, t));
	}

	@Test
	public void test4same4() {
		sm = new SpiralMatrix(4);
		m = sm.calculate();
		t = new int[][] { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
		assertTrue(m[0].length == t[0].length);
		assertTrue(m.length == t.length);
		assertTrue(cycle(m, t));
	}

	@Test
	public void test1same1() {
		sm = new SpiralMatrix(1);
		t = new int[][] { { 1 } };
		m = sm.calculate();
		assertTrue(m[0].length == t[0].length);
		assertTrue(m.length == t.length);
		assertTrue(cycle(m, t));
	}

	@Test
	public void test1Line() {
		sm = new SpiralMatrix(1, 5);
		t = new int[][] { { 1, 2, 3, 4, 5 } };
		m = sm.calculate();
		assertTrue(m[0].length == t[0].length);
		assertTrue(m.length == t.length);
		assertTrue(cycle(m, t));
	}

	private boolean cycle(int[][] m, int[][] t) {
		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m[0].length; j++)
				if (m[i][j] != t[i][j])
					return false;
		return true;
	}

	@Test
	public void test3same3() {
		sm = new SpiralMatrix(3);
		m = sm.calculate();
		t = new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		assertTrue(m[0].length == t[0].length);
		assertTrue(m.length == t.length);
		assertTrue(cycle(m, t));
	}

	@Test
	public void testCalculateNminorM() {
		sm = new SpiralMatrix(4, 5);
		m = sm.calculate();
		t = new int[][] { { 1, 2, 3, 4, 5 }, { 14, 15, 16, 17, 6 }, { 13, 20, 19, 18, 7 }, { 12, 11, 10, 9, 8 } };
		assertTrue(m[0].length == t[0].length && m.length == t.length && cycle(m, t));
	}

	@Test
	public void testCalculateNmajorM() {
		sm = new SpiralMatrix(5, 4);
		m = sm.calculate();
		t = new int[][] { { 1, 2, 3, 4 }, { 14, 15, 16, 5 }, { 13, 20, 17, 6 }, { 12, 19, 18, 7 }, { 11, 10, 9, 8 } };
		assertTrue(m[0].length == t[0].length && m.length == t.length && cycle(m, t));
	}
}
