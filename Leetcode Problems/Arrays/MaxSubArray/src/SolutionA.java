

public class SolutionA {
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {

            return 0;
        }

        int max = nums[0];
        int pre = nums[0];

        for (int i =1; i <nums.length;i++) {

            pre = Math.max(nums[i], nums[i]+ pre);
            max = Math.max(max,pre);
        }

        return max;
    }

}