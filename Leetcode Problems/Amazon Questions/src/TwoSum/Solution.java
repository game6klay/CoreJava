package TwoSum;

public class Solution{

    public static int[] twoSum(int[] nums, int target) {

        // starting with first index
        // find the number required if in the array
        // return the indices in a different array

        int second=0;
        int first=0;
        int firstInd=0;
        int secondInd=0;

        for (int i=0;i<nums.length;i++) {

            first= nums[i];
            second = first - target;
            for (int j=0;j<nums.length;j++) {
                if (nums[j] == second) {
                    System.out.println(nums[j]);
                    secondInd = j;
                    firstInd=i;
                }
            }
        }

        return new int[]{firstInd,secondInd};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target =6;
        System.out.println(twoSum(nums, target));
    }
}