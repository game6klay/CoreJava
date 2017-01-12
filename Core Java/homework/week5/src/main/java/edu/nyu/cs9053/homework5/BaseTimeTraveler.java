package edu.nyu.cs9053.homework5;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseTimeTraveler implements TimeTraveler {
	
	private final String name;
	private final static int INITIAL_HOURS_OF_TRAVEL = 100*365*24;
	private final AtomicInteger remainingHoursOfTravel;
	
	public BaseTimeTraveler(String name){
		if (name == null){
			throw new NullPointerException();
		}
		this.name = name;
		this.remainingHoursOfTravel = new AtomicInteger(INITIAL_HOURS_OF_TRAVEL);
	}

	public AtomicInteger getRemainingHoursOfTravel(){
		return remainingHoursOfTravel;
	}

	@Override public String getName() {
		return name;
	}

	@Override public Double getRemainingYearsOfTravel() {
		return remainingHoursOfTravel.doubleValue()/24/365;
	}
	
	public abstract void adjust(Time unit, int amount, boolean ahead);
}
	
	

