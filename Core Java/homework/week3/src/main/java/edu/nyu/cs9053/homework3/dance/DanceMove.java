package edu.nyu.cs9053.homework3.dance;

/**
 * Author : Jay Patel
 */

public class DanceMove {

	// single constructor

	public DanceMove(String idealMove, String userMove) {
			this.idealMove = idealMove;
			this.userMove = userMove;
	}

	// instance variables

	private final String idealMove;
	private final String userMove;

	// instance methods

	public String getIdealMove() {
		return idealMove;
	}

	public String getUserMove() {
		return userMove;
	}

	public boolean correctMove() {
		if (this.userMove.equals(this.idealMove))
			return true;
		else 
			return false;
	}

}