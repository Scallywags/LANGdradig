package scallywags.langdradig.generate;

import java.util.*;

public class SymbolTable {
    private Set<String> ids = new HashSet<>();

    private Stack<Scope> scopes = new Stack<>();

    public void openScope() {
        scopes.add(new Scope());
    }

    public void closeScope() {
        scopes.pop();
    }

    /**
     * @param id   the identifier
     * @param type the type
     * @return true if the identifier was successfully added, false if the identifier was already declared in the current scope
     */
    public boolean add(String id, Type type) {
        ids.add(id);
        return scopes.peek().add(id, type);
    }

    public boolean contains(String id) {
        return scopes.stream().anyMatch(scope -> scope.contains(id));
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

        public boolean add(String identifier, Type type) {
            return types.putIfAbsent(identifier, type) == null;
        }

        public boolean contains(String identifier) {
            return types.containsKey(identifier);
        }

        public Type getType(String identifier) {
            return types.get(identifier);
        }

        @Override
        public String toString() {
            return "Scope{\ntypes = " + types + "}";
        }
    }

    public Set<String> getIDs() {
        return ids;
    }

}
