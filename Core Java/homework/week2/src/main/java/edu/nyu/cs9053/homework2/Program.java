package edu.nyu.cs9053.homework2;

/**
 * verified the output by manually put in the values in and checking the required output
 */
public class Program {

    // based on the intial arguments gps or annuity
    // where the default is invalid output

    private static final String GPS = "gps";
	private static final String ANNUITY = "annuity";
	private static final String COMPOUND = "compound";

    public static void main(String[] args) {
    	
    	int arguments = args.length;
    	
    	if(arguments <= 3) {
    		invalidArgument();
    		return;
    	}
    	
    	String operation = args[0];
    	
    	switch (operation) {
    		case GPS:
    			Gps[] gpses = new Gps[args.length-1];
    			for (int i = 0; i < gpses.length; i++) {
					gpses[i] = parseGps(args[i+1]);
				}
    			encodePolyline(gpses);
    			break;
    		case ANNUITY:
    			if(args.length == 5 && args[1].equals(COMPOUND)) {
    				computeCompoundAnnuity(args[2], args[3], args[4]);
    			} else if(args.length == 4) {
    				computeAnnuity(args[1], args[2], args[3]);
    			} else {
    				invalidArgument();
    			}
    			break;
    		default:
    			invalidArgument();
    			break;
		}

    }
    
    private static void encodePolyline(Gps[] gpses) {
    	PolylineEncoder encoder = new PolylineEncoder();
		System.out.println(encoder.encodePolyline(gpses));
    }

        // when the input is Annuity
        // controlling based on the integer years for annuity
    
    private static void computeAnnuity(String amountString, String interestString, String yearsString) {
    	AnnuityCalculator calculator = new AnnuityCalculator();
		double amount = Double.parseDouble(amountString);
		double interest = Double.parseDouble(interestString);
		int years = Integer.parseInt(yearsString);
		if(years == 15) {
			calculator.computeFutureValueOfAnnuityIn15Years(amount, interest);
		} else if(years == 30 ) {
			calculator.computeFutureValueOfAnnuityIn30Years(amount, interest);
		} else {
			calculator.computeFutureValueOfAnnuity(amount, interest, years);
		}
    }

        // controlling based on the integer years for compound annuity

    private static void computeCompoundAnnuity(String amountString, String interestString, String yearsString) {
    	AnnuityCalculator calculator = new AnnuityCalculator();
		double amount = Double.parseDouble(amountString);
		double interest = Double.parseDouble(interestString);
		int years = Integer.parseInt(yearsString);
		if(years == 15) {
			calculator.computeMonthlyCompoundedFutureValueOfAnnuityIn15Years(amount, interest);
		} else if(years == 30 ) {
			calculator.computeMonthlyCompoundedFutureValueOfAnnuityIn30Years(amount, interest);
		} else {
			calculator.computeMonthlyCompoundedFutureValueOfAnnuity(amount, interest, years);
		}
    }
    
    private static Gps parseGps(String coordinates) {
    	String[] tempCoordinates = coordinates.split(",");
    	return new Gps(Double.parseDouble(tempCoordinates[0]), Double.parseDouble(tempCoordinates[1]));
    }
    
    private static void invalidArgument() {
    	System.out.println("Invalid argumets.");
    }

}
