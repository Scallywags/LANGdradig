package scallywags.langdradig.generate.except;

@SuppressWarnings("serial")
public class UndeclaredException extends CheckerException {

	public UndeclaredException(String identifier) {
		super(String.format("%s was not declared.", identifier));
	}

}
