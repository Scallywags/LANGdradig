package scallywags.langdradig.generate;

import java.util.Arrays;

public interface Type {
	
	public String getName();
	public int getSize();
	public String toString();	//returns the type declaration as of in the AST.
	
	public static final Type INTEGER = new Type() {
		@Override public String getName() {return "INTEGER";}
		@Override public int getSize() {return 1;}
		@Override public String toString() {return "IntType";}
        @Override public boolean equals(Object o) {return o == INTEGER;}
	};
	
	public static final Type BOOLEAN = new Type() {
		@Override public String getName() {return "BOOLEAN";}
		@Override public int getSize() {return 1;}
		@Override public String toString() {return "BoolType";}
        @Override public boolean equals(Object o) {return o == BOOLEAN;}
	};

    public static final Type EMPTY_ARRAY = new Type() {
        @Override public String getName() {return "EMPTY_ARRAY";}
        @Override public int getSize() {return 1;}
        @Override public String toString() {return "EmptyType";}
        @Override public boolean equals(Object o) {return o == EMPTY_ARRAY;}
    };
	
	public static Type ARRAY(Type elemType, int numElems) {
		return new ArrayType(elemType, numElems);
	}

    static class Array implements Type {
        @Override public String getName() {return "ARRAY";}
        @Override public int getSize() {return -1;}
        @Override public String toString() {return "ArrayType";}
    }
	
	static class ArrayType extends Array {
		private final Type elemType;
		private final int numElems;
		
		private ArrayType(Type elemType, int numElems) {
			if (elemType == null) {
				throw new IllegalArgumentException("Cannot construct an arraytype of nulltype!");
			}
			this.elemType = elemType;
			this.numElems = numElems;
		}
		
		public Type getElemType() {
			return elemType;
		}
		public int getElemCount() {
			return numElems;
		}
		
		@Override public String getName() {return "ARRAY";}
		@Override public int getSize() {return numElems + 1;}
		@Override public String toString() {return "ArrayType " + numElems + " " + elemType;}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (elemType.hashCode());
			result = prime * result + numElems;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
            if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ArrayType other = (ArrayType) obj;
			if (!elemType.equals(other.elemType))
				return false;
			if (numElems != other.numElems)
				return false;
			return true;
		}
	}

}
