package scallywags.langdradig.generate;

import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {
    private int scope = 0;

    // This list is used for the IDE to be able to print the variables and their scopes
    private List<Variable> variables = new ArrayList<>();

    private Stack<Scope> scopes = new Stack<>();

    public void openScope() {
        scope++;
        scopes.add(new Scope());
    }

    public void closeScope() {
        scope--;
        scopes.pop();
    }

    /**
     * @param id   the identifier
     * @param type the type
     * @return true if the identifier was successfully added, false if the identifier was already declared in the current scope
     */
    public boolean add(String id, Type type, boolean isShared) {
        variables.add(new Variable(id, type, scope, isShared));
        return scopes.peek().add(id, type, isShared);
    }

    public boolean contains(String id) {
        return scopes.stream().anyMatch(scope -> scope.contains(id));
    }

    public boolean isShared(String id) {
        for (Scope scope : scopes) {
            if (scope.contains(id)) {
                return scope.isShared(id);
            }
        }
        return false;
    }

    /**
     * @param id the identifier
     * @return the Type of the identifier, or null if the identifier could not be found in any of the scopes.
     */
    public Type getType(String id) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Scope scope = scopes.get(i);
            Type type = scope.getType(id);
            if (type != null) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return scopes.toString();
    }


    private class Scope {
        Map<String, Type> types = new HashMap<>();
        Map<String, Boolean> shared = new HashMap<>();

        public boolean add(String identifier, Type type, boolean isShared) {
            shared.put(identifier, isShared);
            return types.putIfAbsent(identifier, type) == null;
        }

        public boolean contains(String identifier) {
            return types.containsKey(identifier);
        }

        public Type getType(String identifier) {
            return types.get(identifier);
        }

        public boolean isShared(String identifier) {
            return shared.get(identifier);
        }

        @Override
        public String toString() {
            return "Scope{\ntypes = " + types + "}";
        }
    }

    public List<Variable> getVariables() {
        return variables;
    }


}
