package scallywags.langdradig.listeners;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import scallywags.langdradig.ide.errors.LANGdradigErrorBuilder;
import scallywags.langdradig.ide.errors.LANGdradigError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeroen Weener on 16/06/2016.
 */
public class LANGdradigErrorListener extends BaseErrorListener {

    private final List<LANGdradigError> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        this.errors.add(LANGdradigErrorBuilder.format(msg, line));
    }

    /** Indicates if the listener has collected any errors. */
    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    /** Returns the (possibly empty) list of errors collected by the listener. */
    public List<LANGdradigError> getErrors() {
        return this.errors;
    }
}
