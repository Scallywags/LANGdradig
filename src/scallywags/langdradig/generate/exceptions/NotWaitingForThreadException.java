package scallywags.langdradig.generate.exceptions;

import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by Jeroen Weener on 23/06/2016.
 */
public class NotWaitingForThreadException extends CheckerException {
    private String id;

    public NotWaitingForThreadException(ParseTree subTree, String id) {
        super(subTree, "Current thread is not waiting for child thread " + id);
        this.id = id;
    }

    public String getID() {
        return id;
    }
}
