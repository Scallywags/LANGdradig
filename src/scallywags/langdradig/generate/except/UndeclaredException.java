package scallywags.langdradig.generate.except;

@SuppressWarnings("serial")
public class UndeclaredException extends CheckerException {
	private String identifier;

	public UndeclaredException(String identifier) {
		super(String.format("%s was not declared.", identifier));
		this.identifier = identifier;
	}

    public String getIdentifier() {
        return identifier;
    }

}
