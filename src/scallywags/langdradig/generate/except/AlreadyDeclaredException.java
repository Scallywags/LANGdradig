package scallywags.langdradig.generate.except;

@SuppressWarnings("serial")
public class AlreadyDeclaredException extends CheckerException {
	
	public AlreadyDeclaredException(String identifier) {
		super(String.format("%s was already delcared", identifier));
	}

}
