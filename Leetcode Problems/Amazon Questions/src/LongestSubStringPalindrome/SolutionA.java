package LongestSubStringPalindrome;

/**
 * Created by jay on 1/7/17.
 */
public class SolutionA {

    public String longestPalindrome (String s) {

        String result = "";
        int currLength =0;

        for (int i =0;i<s.length();i++) {

            if (isPalindrome(s,i-currLength-1,i)) {

                result = s.substring(i-currLength,i+1);
                currLength= currLength+2;
            }

            else if (isPalindrome(s,i-currLength,i)) {

                result = s.substring(i-currLength,i+1);
                currLength= currLength+1;
            }
        }
        return result;
    }

    public boolean isPalindrome (String s, int start, int end) {

        if (start < 0){
            return false;

        }

        while (start < end) {

            if (s.charAt(start++)!=s.charAt(end--)){

                return false;
            }
        }

        return true;

    }
}
