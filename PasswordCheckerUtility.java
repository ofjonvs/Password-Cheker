package abc;

import java.util.ArrayList;

public class PasswordCheckerUtility extends Object {
	
	public PasswordCheckerUtility() {}
	
	public static void comparePasswords(String password, String passwordConfirm)
	throws UnmatchedException{
		boolean doesNotMatch = !(comparePasswordsWithReturn(password, passwordConfirm));
		if (doesNotMatch) {
			throw new UnmatchedException();
		}				
	}
	
	public static boolean comparePasswordsWithReturn(String password, 
			String passwordConfirm) {
		if (password.equals(passwordConfirm))
			return true;
		else
			return false;		
	}
	
	public static ArrayList<String> getInvalidPasswords
	(ArrayList<String> passwords){
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for (String i : passwords) {
			try {isValidPassword(i);}
			catch(Exception e) {
				invalidPasswords.add(i); //+ e.getMessage());
			}
		}	
		return invalidPasswords;
	}
	
	public static boolean hasBetweenSixAndNineChars(String password) {
		if(password.length() >= 6) {
			if(password.length() <= 9) {
				return true;
			}}
		return false;
	}
	
	public static boolean hasDigit(String password)
            throws NoDigitException {
		for(int i=0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i)))
				return true;
		}
		throw new NoDigitException();		
        	}
  
	public static boolean hasLowerAlpha(String password)
            throws NoLowerAlphaException{
		for(int i=0; i < password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i)))
				return true;
		}
		throw new NoLowerAlphaException();		
	}
	
	public static boolean hasSameCharInSequence(String password)
            throws InvalidSequenceException{
		for(int i=2; i < password.length(); i++) {
			if((password.charAt(i) == (password.charAt(i-1)) && 
					(password.charAt(i) == password.charAt(i-2)))){
				throw new InvalidSequenceException();
			}				
		}
		return true;
	}
	
	public static boolean hasSpecialChar(String password)
            throws NoSpecialCharacterException{
		String specialChars = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
		char[] ch = new char[password.length()];
        for (int i = 0; i < password.length(); i++) {
            ch[i] = password.charAt(i);
        }
        for(char i : ch) {
        	if(specialChars.contains(Character.toString(i))) {
        		return true;
        	}
        }
        throw new NoSpecialCharacterException();
	}
	
	public static boolean hasUpperAlpha(String password)
            throws NoUpperAlphaException{
		for(int i=0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i)))
				return true;
		}
		throw new NoUpperAlphaException();		
	}
	
	public static boolean isValidLength(String password)
            throws LengthException{
		if(password.length() >= 6)
			return true;
		throw new LengthException();
	}
	
	
	
		
	public static boolean isValidPassword(String password)
                throws LengthException, NoUpperAlphaException, NoLowerAlphaException,
                       NoDigitException, NoSpecialCharacterException, InvalidSequenceException{

		try {isValidLength(password);}
		catch (LengthException e) {
			throw new LengthException(e.getMessage());
			}
		
		try {hasUpperAlpha(password);}
		catch (NoUpperAlphaException e) {
			throw new NoUpperAlphaException(e.getMessage());
		}
		try {hasLowerAlpha(password);}
		catch (NoLowerAlphaException e) {
			throw new NoLowerAlphaException(e.getMessage());
			}
		try {hasDigit(password);}
		catch (NoDigitException e) {
			throw new NoDigitException(e.getMessage());
		}
		try {hasSpecialChar(password);} 
		catch (NoSpecialCharacterException e) {
			throw new NoSpecialCharacterException(e.getMessage());
				}
		try {hasSameCharInSequence(password);}
		catch (InvalidSequenceException e) {
			throw new InvalidSequenceException(e.getMessage());
			}
		
		return true;
				}	
	
	public static boolean isWeakPassword(String password)
            throws WeakPasswordException{
		if(!(hasBetweenSixAndNineChars(password))) {
			return false;			
		}
		throw new WeakPasswordException();
	}

            
            
		}



                       
