package me.cs158.tag.exception;

public class InvalidCountException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8305682084454844244L;

	public InvalidCountException(String message) {
		super(message);
	}
	
	public InvalidCountException() {
		this("Invalid count");
	}
}
