package scallywags.langdradig.generate;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
	
	private int currentOffset = 0;
	private Stack<Scope> scopes = new Stack<>();

	public void openScope() {
		scopes.add(new Scope());
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
		return scopes.peek().add(id, type);
	}

	public boolean contains(String id) {
		return scopes.stream().anyMatch(scope -> scope.contains(id));
	}
	
	/**
	 * 
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
	
	/**
	 * 
	 * @param id the identifier
	 * @return the position in the local memory of the sprockell state.
	 */
	public int getOffset(String id) {
		for (int i = scopes.size() - 1; i >= 0; i--) {
			Scope scope = scopes.get(i);
			Integer offset = scope.getOffset(id);
			if (offset != null) {
				return offset.intValue();
			}
		}
		return -1;
	}
	
	private class Scope {
		Map<String, Type> types = new HashMap<>();
		Map<String, Integer> offsets = new HashMap<>();
		
		public boolean add(String identifier, Type type) {
			boolean success = types.putIfAbsent(identifier, type) == null;
			if (success) {
				offsets.put(identifier, currentOffset);
				currentOffset += type.getSize();
			}			
			return success;
		}
		
		public boolean contains(String identifier) {
			return types.containsKey(identifier);
		}
		
		public Type getType(String identifier) {
			return types.get(identifier);
		}
		
		public Integer getOffset(String identifier) {
			return offsets.get(identifier);
		}
	}
	
}
