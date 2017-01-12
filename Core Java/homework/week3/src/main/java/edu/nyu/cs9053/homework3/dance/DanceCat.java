package edu.nyu.cs9053.homework3.dance;

/**
 * Author : Jay Patel
 */

import java.util.Random;

public class DanceCat {

	public DanceCat (String unparsedMoves,String[] idealMoves){
		// call the second constructor 
		// parsing the unparsedMoves
		this(parseMovesFromString(unparsedMoves), idealMoves);
	}

	public DanceCat (String[] moves, String[] idealMoves){
		// create DanceMove objects and 
		// pass to third constructor 
		this(DanceCat.generateMoves(moves, idealMoves));
	}

	public DanceCat (DanceMove[] danceMoves){
		// should delegate to the fourth constructors
		// ask how to compile and run and check 
		this("Jayp2311", danceMoves);
	}
		// instance variables

	private final String name;
	private final DanceMove[] danceMoves;

	public DanceCat (String name, DanceMove[] danceMoves){
		this.name = name;
		this.danceMoves = danceMoves;
	}

	private static DanceMove[] generateMoves(String[] moves, String[] idealMoves) {
 		DanceMove[] danceMoves = new DanceMove[18];
 		for (int i = 0; i < danceMoves.length; i++) {
 			danceMoves[i] = new DanceMove(moves[i], idealMoves[i]);
 		}
 		return danceMoves;
 	}

	// getter methods  

	public String getName(){
		return this.name;
	}
	
	// getter methods

	public DanceMove[] getDanceMoves(){
		return this.danceMoves;
	} 
	// the methods required for this class

	public int getNumberOfCorrectMoves() {
		int correctMoves = 0;
		for (int i = 0; i < danceMoves.length; i++) {
			if (danceMoves[i].correctMove()){
				correctMoves++;
		}
	}
		return correctMoves;
	}

	// the methods required for this class
	
	public static String [] parseMovesFromString (String unparsedMoves) {
		int totalAllowedMoves =18;
		String[] resultStringOfMoves = new String[totalAllowedMoves];
	
		for(int k=0;k<18;k++)
		{
			if(k<unparsedMoves.length())
			{
				resultStringOfMoves[k] = Character.toString(unparsedMoves.charAt(k));
			}
			else resultStringOfMoves[k]="";
		}
		return resultStringOfMoves;

	}

	// the methods required for this class

	public static int getComputerLevel (){

		Random randomLevel = new Random();
		int lowLimit = 0;
		int highLimit = 100;
		int randomLevelGenerated = randomLevel.nextInt(highLimit-lowLimit) + lowLimit;
		return randomLevelGenerated;
	}



}