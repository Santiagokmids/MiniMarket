package exceptions;

public class UnderAgeException extends Exception {
	 	
	private static final long serialVersionUID = 1;

	public UnderAgeException() {
		super("The person can't be under-age");
	 }
}
