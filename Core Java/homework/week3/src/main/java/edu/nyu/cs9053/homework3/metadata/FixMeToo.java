package edu.nyu.cs9053.homework3.metadata;

/**
 * Author : Jay Patel
 */
public class FixMeToo {

    private final boolean escape;

    public FixMeToo(boolean escape) {
        this.escape = escape;
    }

    public String analyzeMetadata(String metadata) {
        return escape ? String.format("\"%s\"", metadata) : metadata;
    }

}
