package scallywags.langdradig.generate;

import java.util.*;

/**
 * Created by Jeroen Weener on 23/06/2016.
 *
 * Table that keeps track of the threads in the program. Has extended functionality for the IDE
 */
public class ForkTable {
    private Stack<ProcessScope> scopes = new Stack<>();
    
    private List<ProcessScope> scopeList = new ArrayList<>();		//used for IDE only
    private int depth = 0;									//used for IDE only

    public void openScope(String name) {
        ProcessScope scope = new ProcessScope(name, depth);
        scopes.add(scope);
        scopeList.add(scope);
        depth++;
    }

    public void closeScope() {
        if (scopes.size() > 0) {
            scopes.pop();
            depth--;
        }
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
        for (ProcessScope scope : scopes) {
            if (scope.containsThread(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean waitedOnAll() {
        return scopes.size() <= 0 || scopes.peek().getThreads().values().stream().allMatch(e -> e);
    }

    public String getNotWaitedOn() {
        return scopes.peek().getThreads().entrySet().stream().filter(e -> !e.getValue()).findFirst().get().getKey();
    }

    public boolean getWaitedOn(String id) {
        Boolean b = scopes.peek().getThreads().get(id);
        return b == null ? false : b;
    }

    public List<ProcessScope> getScopeList() {
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
        if (scopes.size() > 0) {
            Type result = scopes.peek().getSymbolTable().getType(identifier);
            if (result == null) {
                for (ProcessScope scope : scopes) {
                    SymbolTable symbolTable = scope.getSymbolTable();
                    // isShared returns false if the identifier is not in the symbolTable
                    if (symbolTable.isShared(identifier)) {
                        result = symbolTable.getType(identifier);
                    }
                }
            }
        return result;
        }
        return null;
    }


    // The inner class Scope

    public class ProcessScope {
        // Every process has its own symboltable
        private SymbolTable symbolTable = new SymbolTable();
        private Map<String, Boolean> threads = new HashMap<>();
        private String name;
        private int depth;

        public ProcessScope(String name, int depth) {
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

        public boolean containsThread(String identifier) {
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
