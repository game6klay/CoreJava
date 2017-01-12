package edu.nyu.cs9053.homework5;

public class DoubleTimeTraveler extends BaseTimeTraveler implements TimeTraveler {

	public DoubleTimeTraveler(String name) {
		super(name);
	}

	@Override public void adjust(Time unit, int amount, boolean ahead) {
		double hoursOfTravel = getRemainingHoursOfTravel().doubleValue();
		if (hoursOfTravel < 0d){
			hoursOfTravel = 0d;
		}
		
		switch(unit){
		case Hours:
			hoursOfTravel -= 2 * amount;
			break;
			
		case Days:
			hoursOfTravel -= 2 * amount * 24d;
			break;
		}
		getRemainingHoursOfTravel().set((int)hoursOfTravel);
	}
}


