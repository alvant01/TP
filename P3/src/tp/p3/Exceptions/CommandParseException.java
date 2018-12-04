package tp.p3.Exceptions;

public class CommandParseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandParseException() {
		super();
	}
	
	public CommandParseException(String mensaje) {
		super(mensaje);
	}

}
