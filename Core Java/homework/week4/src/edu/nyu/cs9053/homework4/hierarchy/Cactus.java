package edu.nyu.cs9053.homework4.hierarchy;

public abstract class Cactus {

	private final String name;
	private final String location;
	private final LeafType leafType;
	private final boolean isFlowering;
	private final boolean hasEdibleFruit;

	protected Cactus(String name, String location, LeafType leafType, boolean isFlowering, boolean hasEdibleFruit) {
		this.name = name;
		this.location = location;
		this.leafType = leafType;
		this.isFlowering = isFlowering;
		this.hasEdibleFruit = hasEdibleFruit;
	}

	public boolean getIsFlowering() {
		return isFlowering;
	}

	public boolean getHasEdibleFruit() {
		return hasEdibleFruit;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public LeafType getLeafType() {
		return leafType;
	}

	@Override 
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Cactus other = (Cactus) obj;

		boolean isNameSame = (name!=null && other.getName()!=null) ? name.equals(other.getName()) : (name==null && other.getName()==null) ? true : false;

		boolean isLocationSame = (location!=null && other.getLocation()!=null) ? location.equals(other.getLocation()) : (location==null && other.getLocation()==null) ? true : false;

		boolean isLeafTypeSame = (leafType!=null && other.getLeafType()!=null) ? leafType.equals(other.getLeafType()) : (leafType==null && other.getLeafType()==null) ? true : false;

		boolean isFloweringSame = isFlowering == other.getIsFlowering() ? true : false;

		boolean hasEdibleFruitSame = hasEdibleFruit == other.getHasEdibleFruit() ? true : false;

		return isNameSame && isLocationSame && isLeafTypeSame && isFloweringSame && hasEdibleFruitSame;
	}

	@Override 
	public int hashCode() {
		int randomPrime = 41;
		int result = 15;
		int nameHash = name != null ? name.hashCode() : 0;
		int locationHash = location != null ? location.hashCode() : 0;
		int leafTypeHash = leafType != null ? leafType.hashCode() : 0;
		int isFloweringHash = isFlowering ? 0 : 1;
		int hasEdibleFruitHash = hasEdibleFruit ? 0 : 1;
		return result + randomPrime * (nameHash + locationHash + leafTypeHash + isFloweringHash + hasEdibleFruitHash); 
	}

	public static void main(String[] args) {

		Armatocereus ar1 = new Armatocereus("arma1", "florida");
		Armatocereus ar2 = new Armatocereus("arma1", "florida");
		Armatocereus bc3 = new Armatocereus("arma1", "miami");
		Consolea c1 = new Consolea("arma1", "florida");
		Opuntia o1 = new Opuntia("arma1", "florida");
		System.out.println(ar1.getName());
		System.out.println(ar1.getLeafType());
		System.out.println(ar1.getLocation());
		System.out.println(ar1.equals(ar2));
		System.out.println(ar1.equals(bc3));
		System.out.println(ar1.getIsFlowering());
		System.out.println(ar1.equals(c1));
		System.out.println(ar1.equals(o1));
		System.out.println(o1.getLeafType());
		System.out.println(o1.getHasEdibleFruit());
		
	}

}