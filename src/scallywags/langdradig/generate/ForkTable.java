package scallywags.langdradig.generate;

import java.util.*;

/**
 * Created by Jeroen Weener on 23/06/2016.
 */
public class ForkTable {
    private Stack<Scope> scopes = new Stack<>();
    private List<Scope> scopeList = new ArrayList<>();
    private int depth = 0;

    public void openScope(String name) {
        depth++;
        Scope scope = new Scope(name, depth);
        scopes.add(scope);
        scopeList.add(scope);
    }

    public void closeScope() {
        scopes.pop();
    }

    /**
     * @param id   the identifier
     */
    public void addThread(String id) {
        scopes.peek().addThread(id);
    }

    public void waitForThread(String id) {
        scopes.peek().waitForThread(id);
    }

    public boolean contains(String id) {
        for (Scope scope : scopes) {
            if (scope.contains(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean waitedOnAll() {
        return scopes.peek().getThreads().values().stream().allMatch(e -> e);
    }

    public String getNotWaitedOn() {
        return scopes.peek().getThreads().entrySet().stream().filter(e -> !e.getValue()).findFirst().get().getKey();
    }

    public boolean getWaitedOn(String id) {
        Boolean b = scopes.peek().getThreads().get(id);
        return b == null ? false : b;
    }

    public List<Scope> getScopeList() {
        return scopeList;
    }



    //Methods needed to access the symbol table in the current thread

    public void openScopeSymbolTable() {
        scopes.peek().getSymbolTable().openScope();
    }

    public void closeScopeSymbolTable() {
        scopes.peek().getSymbolTable().closeScope();
    }

    public boolean add(String identifier, Type type, boolean isShared) {
        return scopes.peek().getSymbolTable().add(identifier, type, isShared);
    }

    public Type getType(String identifier) {
        Type result = scopes.peek().getSymbolTable().getType(identifier);
        if (result == null) {
            for (Scope scope : scopes) {
                SymbolTable symbolTable = scope.getSymbolTable();
                // isShared returns false if the identifier is not in the symbolTable
                if (symbolTable.isShared(identifier)) {
                    result = symbolTable.getType(identifier);
                }
            }
        }
        return result;
    }




    // The inner class Scope

    public class Scope {
        private SymbolTable symbolTable = new SymbolTable();
        private Map<String, Boolean> threads = new HashMap<>();
        private String name;
        private int depth;

        public Scope(String name, int depth) {
            this.depth = depth;
            this.name = name;
            symbolTable.openScope();
        }

        public SymbolTable getSymbolTable() {
            return this.symbolTable;
        }

        public Map<String, Boolean> getThreads() {
            return threads;
        }

        public void addThread(String identifier) {
            threads.put(identifier, false);
        }

        public void waitForThread(String identifier) {
            threads.put(identifier, true);
        }

        public boolean contains(String identifier) {
            return threads.containsKey(identifier);
        }

        public int getDepth() {
            return depth;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
