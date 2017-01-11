package TwoSum;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by jay on 1/6/17.
 */
public class SolutionB {

    public static int[] twoSum(int[] nums, int target) {

        // put all the elements of the array into the map
        // then check if all the items of them map if there is a pair which adds up to the target
        // get the pair and apply indexOf to the get the index add them into an array to get the

        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i =0;i<nums.length;i++) {
            map.put(nums[i], target- nums[i]);

        }

        for (Integer key: map.keySet()) {

            if (map.get(key) + key == target) {

                result[0] = key;
                result[1] = map.get(key);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target =6;
        System.out.println(twoSum(nums, target));
    }
}
