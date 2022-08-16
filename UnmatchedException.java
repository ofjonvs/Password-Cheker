package abc;

public class UnmatchedException extends Exception {
	
	/**
	 * Constructor.
	 */
	public UnmatchedException() {
		this("The passwords do not match");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public UnmatchedException(String message) {
		super(message);
	}

}
