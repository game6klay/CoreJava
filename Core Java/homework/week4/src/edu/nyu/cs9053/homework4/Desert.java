package edu.nyu.cs9053.homework4;

public enum Desert {
	
	ANTARTIC(14200000),
	ARTIC(13900000),
	SAHARA(9100000),
	ARABIAN(2600000),
	GOBI(1300000),
	PATAGONIAN(670000),
	GREATVICTORIA(647000),
	KALAHARI(570000),
	GREATBASIN(490000),
	SYRIAN(490000);

	private final int areaOfDesert; // in square kilometers

	Desert (int areaOfDesert){
		this.areaOfDesert = areaOfDesert;
	}

	public int getAreaKm(){
		return areaOfDesert;
	}

	public static void printDesertArea(Desert... deserts) {
		for (Desert desert : deserts) {
			System.out.println("The Area in square kilometers of "+ desert + " is " + desert.getAreaKm());
		}
	}

	public static void main(String[] args) {
		Desert[] deserts = new Desert[10];
		deserts[0] = Desert.ANTARTIC;
		deserts[1] = Desert.ARABIAN;
		deserts[2] = Desert.ARTIC;
		deserts[3] = Desert.GOBI;
		deserts[4] = Desert.GREATBASIN;
		deserts[5] = Desert.GREATVICTORIA;
		deserts[6] = Desert.KALAHARI;
		deserts[7] = Desert.SAHARA;
		deserts[8] = Desert.PATAGONIAN;
		deserts[9] = Desert.SYRIAN;

		Desert.printDesertArea(deserts);
		
	}

}


