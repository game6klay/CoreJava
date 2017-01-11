public class Solution {
    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) {

            return;
        }

        int totalZeroes = 0;
        int zeroCounter =0;
        int len = nums.length;

        for (int i=0;i<nums.length;i++) {

            if (nums[i]==0) {
                totalZeroes ++;
                zeroCounter ++;
            }
            if (nums[i] != 0 && zeroCounter >0) {
                nums[i-zeroCounter] = nums[i];
                zeroCounter = 0;
            }
        }

        for (int i =totalZeroes;i>0;i++) {
            if (totalZeroes == 0) {

                break;
            }

            else {
                nums[len - totalZeroes] = 0;
                totalZeroes --;
            }

        }

    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}