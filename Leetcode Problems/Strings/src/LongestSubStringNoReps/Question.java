package LongestSubStringNoReps;

import java.util.HashMap;

public class Question {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer>  map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int counter =0;

        for (int i=0;i<s.length();i++) {

            if (map.containsKey(s.charAt(i))) {

                counter = 0;
            }

            else {
                map.put(s.charAt(i),1);
                counter++;
            }

            max = Math.max(max, counter);
        }

        return max;

    }
}