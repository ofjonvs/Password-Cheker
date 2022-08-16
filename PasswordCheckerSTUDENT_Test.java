package abc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * This is your test file.  Complete the following test cases to test your project where they make sense.
 * Include additional test cases if you like.  
 *
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {
	
	PasswordCheckerUtility p1;

	@Before
	public void setUp() throws Exception {
		p1 = new PasswordCheckerUtility();
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		Exception exception = assertThrows(Exception.class, () -> p1.isValidLength("A1a*"));
		assertEquals("The password must be at least 6 characters long", exception.getMessage());
	}

	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		Exception exception = assertThrows(Exception.class, () -> p1.hasUpperAlpha("abcd123*"));
		assertEquals("The password must contain at least one uppercase alphabetic character", exception.getMessage());
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		Exception exception = assertThrows(Exception.class, () -> p1.hasLowerAlpha("ABCD123*"));
		assertEquals("The password must contain at least one lowercase alphabetic character", exception.getMessage());
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		Exception exception = assertThrows(Exception.class, () -> p1.isWeakPassword("abcd12A*"));
		assertEquals("The password is OK but weak - it contains fewer than 10 characters", exception.getMessage());
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		Exception exception = assertThrows(Exception.class, () -> p1.hasSameCharInSequence("abcdAAA123*"));
		assertEquals("The password cannot contain more than two of the same character in sequence", exception.getMessage());
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		Exception exception = assertThrows(Exception.class, () -> p1.hasDigit("abcdABCD*"));
		assertEquals("The password must contain at least one digit", exception.getMessage());
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(p1.isValidPassword("abcdABCD1234*"));
		} catch (LengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoUpperAlphaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoLowerAlphaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoDigitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSpecialCharacterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidSequenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> passwords = new ArrayList<>();
		ArrayList<String> invalidPasswords = new ArrayList<>();
		ArrayList<String> invalidPasswordsCheck = new ArrayList<>();
		passwords.add("a1A#b1Bc1Cd1D");
		passwords.add("334455BB#");
		passwords.add("Im2cool4U#");
		passwords.add("george2ZZZ#");
		passwords.add("4Sale#");
		passwords.add("bertha22");
		passwords.add("4wardMarch#");
		passwords.add("august30");
		passwords.add("a2cDe");
		passwords.add("ApplesxxYYzz#");
		passwords.add("aa11bb");
		passwords.add("pilotProject");
		passwords.add("myPassword");
		passwords.add("myPassword2");
		passwords.add("myPassword2#");
		invalidPasswordsCheck.add("334455BB#");
		invalidPasswordsCheck.add("george2ZZZ#");
		invalidPasswordsCheck.add("bertha22");
		invalidPasswordsCheck.add("august30");
		invalidPasswordsCheck.add("a2cDe");
		invalidPasswordsCheck.add("ApplesxxYYzz#");
		invalidPasswordsCheck.add("aa11bb");
		invalidPasswordsCheck.add("pilotProject");
		invalidPasswordsCheck.add("myPassword");
		invalidPasswordsCheck.add("myPassword2");
		invalidPasswords = p1.getInvalidPasswords(passwords);
		assertTrue(invalidPasswords.equals(invalidPasswordsCheck));		
	}
	
	 
	 
}
