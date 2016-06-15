package scallywags.langdradig.generate.except;

@SuppressWarnings("serial")
public abstract class CheckerException extends RuntimeException {

	public CheckerException(String message) {
		super(message);
	}

}
