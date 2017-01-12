package edu.nyu.cs9053.homework5;

public class MadScientist {

    private final TimeMachine timeMachine;

    public MadScientist(TimeMachine timeMachine) {
        this.timeMachine = timeMachine;
    }

    public static void main(String[] args) {
    	
        // make a MadScientist / TimeMachine and 3 TimeTraveler implementations
         // make a MadScientist / TimeMachine and 3 TimeTraveler implementations
        TimeMachine timeMachine = new TimeMachine();
        MadScientist madScientist = new MadScientist(timeMachine);
        LinearTimeTraveler linearDecayTravel = new LinearTimeTraveler("Linear");
        DoubleTimeTraveler doubleDecayTravel = new DoubleTimeTraveler("Double");
        ExponentialTimeTraveler exponentialDecayTravel = new ExponentialTimeTraveler("Exponential", 10d);
        
    	
        // experiment on each TimeTraveler
    	boolean linearExhausted = (linearDecayTravel.getRemainingYearsOfTravel() <= 0d);
    	boolean doubleExhausted = (doubleDecayTravel.getRemainingYearsOfTravel() <= 0d);
    	boolean exponentialExhausted = (exponentialDecayTravel.getRemainingYearsOfTravel() <= 0d);
    	boolean allExhausted = (linearExhausted && doubleExhausted && exponentialExhausted);
    	
    	while (!allExhausted){
    		
    			if (!linearExhausted){
    				madScientist.experiment(linearDecayTravel);
    			}
    			if (!doubleExhausted){
    				madScientist.experiment(doubleDecayTravel);
    			}
    			if (!exponentialExhausted){
    				madScientist.experiment(exponentialDecayTravel);
    			}
    		}
    	}
    	

     public void experiment(TimeTraveler timeTraveler) throws IllegalArgumentException{
        // invoke the time-machine and print how much time has passed using a callback and adjust the time traveler's ability to travel
        if (timeTraveler.getName()== null) {
            throw new NullPointerException();
            }
        
        timeMachine.travel(timeTravelerCallback, new TimeTravelCallback() {
            @Override public void leaped(Time unit, int amount, boolean ahead) {               
                if (timeTravelerCallback.getRemainingYearsOfTravel() < 0d) {
                    System.out.println( timeTravelerCallback.getName() + " can not travel now");
                    return;
                }
                else {
                System.out.println(amount + " " + unit + " has passed till now" );
                timeTravelerCallback.adjust(unit, amount, ahead);
                System.out.println( timeTravelerCallback.getName() + " has remaining travel availability for years " +
                    timeTravelerCallback.getRemainingYearsOfTravel());
                }
            }
        });
    }
}
  
    	


