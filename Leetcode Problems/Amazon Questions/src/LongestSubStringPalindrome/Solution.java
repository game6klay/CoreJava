package LongestSubStringPalindrome;

/**
 * Created by jay on 1/6/17.
 */
public class Solution {

    public int longestPalindrome(String s) {
        int max =0;

        for (int i =1;i<s.length()-1;i++) {
            isPalindrome(s.substring(0,i));

            if (max<i) {
                max= i;
            }
        }
        return max;

    }

    private boolean isPalindrome (String s) {

        int left = 0;
        int right = s.length()-1;

        while(left<=right) {

            if (s.charAt(left) == s.charAt(right)) {
                left ++;
                right--;
                continue;
            }
            else {
                return false;
            }
        }

        if (left == right || (right-left ==1)) {

            return true;
        }

        return false;
    }
}
