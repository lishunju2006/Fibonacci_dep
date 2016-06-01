package com.emc.interview.servlet;

public class Validator {

	private static int MAXIMUM_N = 100000;

	public static void validate(String s) throws ValidatorException {

		if (s == null)
			throw new ValidatorException(1001, "n must by provided.");

		int n = 0;
		try {
			n = Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			throw new ValidatorException(1002, "n must be a number.");
		}

		if (n < 0)
			throw new ValidatorException(1003, "negative number is invalid.");

		if (n > MAXIMUM_N)
			throw new ValidatorException(1004, "n is bigger than the maximum.");

	}
}
