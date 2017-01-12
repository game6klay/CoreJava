package edu.nyu.cs9053.homework5;

public class ExponentialTimeTraveler extends BaseTimeTraveler implements TimeTraveler {

	private final Double decayConstant;

	public ExponentialTimeTraveler(String name, Double decayConstant) {
		super(name);
		this.decayConstant = decayConstant;
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
    
    Double actualTravelTime = Math.pow(Math.E,(-1d)*(this.decayConstant)*hoursOfTravel);
    hoursOfTravel -= actualTravelTime;
    getRemainingHoursOfTravel().set((int)hoursOfTravel);
	}
}
