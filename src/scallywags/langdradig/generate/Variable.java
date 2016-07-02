package scallywags.langdradig.generate;

/**
 * Created by Jeroen Weener on 20/06/2016.
 * Helper class for storing the name, type, scope and sharedstate of a variable
 */
public class Variable {
    private String variable;
    private Type type;
    private int scope;
    private boolean shared;

    public Variable(String variable, Type type, int scope, boolean shared) {
        this.variable = variable;
        this.scope = scope;
        this.type = type;
        this.shared = shared;
    }

    public String getVariable() {
        return variable;
    }

    public int getScope() {
        return scope;
    }

    public Type getType() {
        return type;
    }

    public boolean isShared() {
        return shared;
    }

    @Override
    public String toString() {
        return variable + " - " + type.getName();
    }
}
