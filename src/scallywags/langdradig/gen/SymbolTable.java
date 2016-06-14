package scallywags.langdradig.gen;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
	
	Stack<Map<String, Type>> scopes = new Stack<>();

	public void openScope() {
		scopes.add(new HashMap<>());
	}

	public void closeScope() {
		scopes.pop();
	}

	/**
	 * 
	 * @param id the identifier
	 * @param type the type
	 * @return true if the identifier was succesfully added, false if the identifier was already declared in the current scope
	 */
	public boolean add(String id, Type type) {
		return scopes.peek().putIfAbsent(id, type) == null;
	}

	public boolean contains(String id) {
		return scopes.stream().anyMatch(set -> set.containsKey(id));
	}
	
	public Type get(String id) {
		for (int i = scopes.size() - 1; i >= 0; i--) {
			Map<String, Type> scope = scopes.get(i);
			Type type = scope.get(id);
			if (type != null) {
				return type;
			}
		}
		return null;
	}

}
