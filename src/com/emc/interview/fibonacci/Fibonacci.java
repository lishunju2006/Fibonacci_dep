package com.emc.interview.fibonacci;

import java.math.BigInteger;
import java.util.Iterator;

import org.apache.log4j.Logger;

/**
 * This class will generate an iteration of fibonacci numbers
 * <p>
 * For more information of fibonacci number, please refer to <a
 * href="https://en.wikipedia.org/wiki/Fibonacci_number"
 * >https://en.wikipedia.org/wiki/Fibonacci_number</a>
 * 
 * @author Jun Zeng
 * 
 */
public class Fibonacci implements Iterable<BigInteger> {
	private static int CACHE_LIMIT = 5000;

	private static Logger logger = Logger.getLogger(Fibonacci.class);

	static private class FibonacciIterator implements Iterator<BigInteger> {

		private static BigInteger[] CACHE = new BigInteger[CACHE_LIMIT];

		static {
			logger.info("BUILDING CACHE...");
			long current = System.currentTimeMillis();
			CACHE[0] = BigInteger.valueOf(0);
			CACHE[1] = BigInteger.valueOf(1);
			for (int i = 2; i < CACHE_LIMIT; ++i) {
				CACHE[i] = CACHE[i - 1].add(CACHE[i - 2]);
			}
			logger.info("BUILD CACHE: "
					+ (System.currentTimeMillis() - current));
		}

		int i;
		int n;
		BigInteger f1;
		BigInteger f2;

		public FibonacciIterator(int n) {
			this.n = n;
			i = 0;
		}

		@Override
		public boolean hasNext() {
			return i < n;
		}

		@Override
		public BigInteger next() {
			BigInteger retval = null;
			if (i < CACHE_LIMIT) {
				retval = CACHE[i];
			} else {
				if (i == CACHE_LIMIT) {
					f1 = CACHE[i - 2];
					f2 = CACHE[i - 1];
				}
				retval = f1.add(f2);
				f1 = f2;
				f2 = retval;
			}
			i++;
			return retval;
		}
	}

	private int n;

	/**
	 * @param n
	 */
	public Fibonacci(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		this.n = n;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<BigInteger> iterator() {
		System.out.print("CMD Linux");
		System.out.print("Browser")
	        System.out.println("Branch DDD");
		return new FibonacciIterator(n);
	}
}
