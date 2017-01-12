package edu.nyu.cs9053.homework3;
import edu.nyu.cs9053.homework3.metadata.FixMeToo;

/**
 * Author : Jay Patel
 */
public class FixMe {

    // every instance variable should be immutable and should be private 
    // and accessed through the public methods declared in the class

    private final String name;

    private final String secondary;

    public FixMe(String name) {
	    this.name = name;
        this.secondary = null;
    }

    public FixMe(String name, String secondary) {
        this.name = name;

        FixMeToo fix = new FixMeToo(true);

        this.secondary = fix.analyzeMetadata(secondary);
    }

    public static FixMe changeName(String name) {
        return new FixMe(name);
    }

    // it can not be static , instance variable secondary used

    public FixMe changeName(String firstName, String lastName) {
        return new FixMe(stickName(firstName, lastName), secondary);
    }

    public static String stickName(String firstName, String lastName) {
        return String.format("%s %s", firstName, lastName);
    }

    public String extractName() {
        return name;
    }

    public String extractSecondary() {
        return secondary;
    }

}
