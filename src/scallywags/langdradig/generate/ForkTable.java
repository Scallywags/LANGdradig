package scallywags.langdradig.generate;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Jeroen Weener on 23/06/2016.
 */
public class ForkTable {
    private Stack<Scope> scopes = new Stack<>();

    public void openScope() {
        scopes.add(new Scope());
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

    private class Scope {
        Map<String, Boolean> threads = new HashMap<>();

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

        @Override
        public String toString() {
            return "Scope{\nthreads = " + threads + "}";
        }
    }
}
