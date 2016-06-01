package com.emc.interview.fibonacci.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.emc.interview.fibonacci.Fibonacci;

public class FibnacciTest {

	// This value is equal to com.emc.interview.fibonacci.CACHE_LIMIT
	private int CACHE_LIMIT = 5000;

	private static List<BigInteger> validatedResult;

	@BeforeClass
	public static void setup() throws IOException {
		validatedResult = new ArrayList<BigInteger>();

		File file = new File("src/com/emc/interview/fibonacci/test/expectedResult.txt");
		FileReader readf = new FileReader(file);

		BufferedReader in = new BufferedReader(readf);

		for (;;) {
			String line = in.readLine();
			if (line == null || line.isEmpty())
				break;
			validatedResult.add(new BigInteger(line));
		}
		in.close();
		readf.close();

	}

	public void testFibnacci(int n) {
		Iterator<BigInteger> f = new Fibonacci(n).iterator();
		for (int i = 0; i < n; ++i) {
			Assert.assertTrue(f.hasNext());
			Assert.assertEquals(validatedResult.get(i), f.next());
		}
		Assert.assertFalse(f.hasNext());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNagetiveThrowException() {
		testFibnacci(-1);
	}

	@Test
	public void testFibnacci_0() {
		testFibnacci(0);
	}

	@Test
	public void testFibnacci_1() {
		testFibnacci(1);
	}

	@Test
	public void testFibnacci_2() {
		testFibnacci(2);
	}

	@Test
	public void testFibnacci_3() {
		testFibnacci(3);
	}

	@Test
	public void testFibnacci_1000() {
		testFibnacci(1000);
	}

	@Test
	public void testFibnacci_10000() {
		testFibnacci(10000);
	}

	@Test
	public void testFibnacci_CACHE_LIMIT_Minus_1() {
		testFibnacci(CACHE_LIMIT - 1);
	}

	@Test
	public void testFibnacci_CACHE_LIMIT() {
		testFibnacci(CACHE_LIMIT);
	}

	@Test
	public void testFibnacci_CACHE_LIMIT_Add_1() {
		testFibnacci(CACHE_LIMIT + 1);
	}

	@Test
	public void testFibnacci_CACHE_LIMIT_Add_2() {
		testFibnacci(CACHE_LIMIT + 2);
	}

}
