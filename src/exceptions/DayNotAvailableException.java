package exceptions;

public class DayNotAvailableException extends Exception{

	private static final long serialVersionUID = 1;
	
	public DayNotAvailableException() {
		super("The day is not available to that person.");
	 }
}
