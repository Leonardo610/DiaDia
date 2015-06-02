package it.uniroma3.diadia;

public class FormatoFileNonValidoException extends Exception {

	/**
	 * Throws an error caused by a wrong format of the file called in program.
	 * @author Leonardo
	 */
	private static final long serialVersionUID = 1L;

	public FormatoFileNonValidoException(String msg){
		super(msg);
	}
}
