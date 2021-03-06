package scallywags.langdradig.ide.errors;

/**
 * Created by Jeroen Weener on 16/06/2016.
 */
public class LANGdradigError implements Comparable<LANGdradigError> {
    private String errorMessage;
    private int lineNumber;

    public LANGdradigError(String errorMessage, int lineNumber) {
        this.errorMessage = errorMessage;
        this.lineNumber = lineNumber;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return errorMessage;
    }

    @Override
    public int compareTo(LANGdradigError e) {
        int theirLineNumber = e.getLineNumber();
        return theirLineNumber == lineNumber ? 0 : lineNumber < theirLineNumber ? -1 : 1;
    }

    @Override
    public boolean equals(Object o) {
        return o == this || o instanceof LANGdradigError && ((LANGdradigError) o).getErrorMessage().equals(errorMessage);
    }
}
