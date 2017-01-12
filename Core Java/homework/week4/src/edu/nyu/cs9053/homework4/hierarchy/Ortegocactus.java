package edu.nyu.cs9053.homework4.hierarchy;

public final class Ortegocactus extends Cactus {
	
	private final String className = Ortegocactus.class.getSimpleName();

	public Ortegocactus (String name, String location) {
		super(name, location, LeafType.SPINE, true, false);
	}

	@Override 
	public int hashCode() {
		int randomPrime = 41;
		int result = 15;
		int classNameHash = className.hashCode();
		return result + randomPrime * (super.hashCode() + classNameHash); 
	}

	@Override 
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}