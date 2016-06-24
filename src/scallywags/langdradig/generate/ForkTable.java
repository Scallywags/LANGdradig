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
    public void addWorker(String id) {
        scopes.peek().startWorker(id);
    }

    public void waitWorker(String id) {
        scopes.peek().waitForWorker(id);
    }

    public boolean contains(String id) {
        return scopes.peek().contains(id);
    }

    public boolean waitedOnAll() {
        return scopes.peek().getWorkers().values().stream().allMatch(e -> e);
    }

    public String getNotWaitedOn() {
        return scopes.peek().getWorkers().entrySet().stream().filter(e -> !e.getValue()).findFirst().get().getKey();
    }

    public boolean getWaitedOn(String id) {
        Boolean b = scopes.peek().getWorkers().get(id);
        return b == null ? false : b;
    }

    private class Scope {
        Map<String, Boolean> workers = new HashMap<>();

        public Map<String, Boolean> getWorkers() {
            return workers;
        }

        public void startWorker(String identifier) {
            workers.put(identifier, false);
        }

        public void waitForWorker(String identifier) {
            workers.put(identifier, true);
        }

        public boolean contains(String identifier) {
            return workers.containsKey(identifier);
        }

        @Override
        public String toString() {
            return "Scope{\nworkers = " + workers + "}";
        }
    }
}
