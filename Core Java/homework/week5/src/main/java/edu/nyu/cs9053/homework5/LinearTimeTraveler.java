package edu.nyu.cs9053.homework5;


public class LinearTimeTraveler extends BaseTimeTraveler implements TimeTraveler {

	public LinearTimeTraveler(String name) {
		super(name);
	}

	@Override public void adjust(Time unit, int amount, boolean ahead) {
		double hoursOfTravel = getRemainingHoursOfTravel().doubleValue();
		if (hoursOfTravel < 0d) {
			hoursOfTravel = 0d;
		}

		switch(unit){
		case Hours:
			hoursOfTravel -= amount;
			break;
		case Days:
			hoursOfTravel -= amount * 24d;
			break;
		}
		getRemainingHoursOfTravel().set((int)hoursOfTravel);
		//set(hoursOFTrvael)
	}
}
