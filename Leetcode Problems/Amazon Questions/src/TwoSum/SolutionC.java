package TwoSum;

import java.util.HashMap;

/**
 * Created by jay on 1/6/17.
 */
public class SolutionC {

    public static int[] twoSum (int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i =0; i< nums.length;i++) {

            if (map.containsKey(target-nums[i])) {

                result[1] = i+1;
                result[0] = map.get(target - nums[i]);
            }
            map.put(nums[i], i+1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target =6;
        System.out.println(twoSum(nums, target));
    }

}
