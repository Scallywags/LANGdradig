package scallywags.langdradig.generate.except;

@SuppressWarnings("serial")
public class AlreadyDeclaredException extends CheckerException {
	private String identifier;
	
	public AlreadyDeclaredException(String identifier) {
		super(String.format("%s was already declared.", identifier));
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}
}
