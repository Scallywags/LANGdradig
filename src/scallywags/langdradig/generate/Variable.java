package scallywags.langdradig.generate;

/**
 * Created by Jeroen Weener on 20/06/2016.
 */
public class Variable {
    private String variable;
    private Type type;
    private int scope;

    public Variable(String variable, Type type, int scope) {
        this.variable = variable;
        this.scope = scope;
        this.type = type;
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

    @Override
    public String toString() {
        return variable + " - " + type.getName();
    }
}
