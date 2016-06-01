package com.emc.interview.servlet.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.emc.interview.servlet.Validator;
import com.emc.interview.servlet.ValidatorException;

public class ValidatorTest {

	//Should be the same with Validator.MAXIMUM_N
	private static int MAXIMUM_N = 100000;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testNull() throws ValidatorException {
		exception.expect(ValidatorException.class);
		exception.expectMessage("n must by provided.");
		Validator.validate(null);
	}
	
	@Test
	public void testNegative() throws ValidatorException {
		exception.expect(ValidatorException.class);
		exception.expectMessage("negative number is invalid.");
		Validator.validate("-1");
	}
	
	@Test
	public void testEqualToMAXIMUM_N() throws ValidatorException{
		Validator.validate(String.valueOf(MAXIMUM_N));
	}
	
	@Test
	public void testBiggerThanMAXIMUM_N() throws ValidatorException {
		exception.expect(ValidatorException.class);
		exception.expectMessage("n is bigger than the maximum.");
		Validator.validate(String.valueOf(MAXIMUM_N + 1));
	}
	
	@Test
	public void testEmpty() throws ValidatorException {
		exception.expect(ValidatorException.class);
		exception.expectMessage("n must be a number.");
		Validator.validate("");
	}

	@Test
	public void testLetter() throws ValidatorException {
		exception.expect(ValidatorException.class);
		exception.expectMessage("n must be a number.");
		Validator.validate("asdsf");
	}
	

	@Test
	public void testLetterNumber() throws ValidatorException {
		exception.expect(ValidatorException.class);
		exception.expectMessage("n must be a number.");
		Validator.validate("11ssss");
	}

	@Test
	public void testLetterNumberLetter() throws ValidatorException {
		exception.expect(ValidatorException.class);
		exception.expectMessage("n must be a number.");
		Validator.validate("asdsf11dsds");
	}
	
	@Test
	public void tesNumbertLetter() throws ValidatorException {
		exception.expect(ValidatorException.class);
		exception.expectMessage("n must be a number.");
		Validator.validate("111dsds");
	}
	
}
