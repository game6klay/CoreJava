import java.util.HashMap;

public class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int majorityElement =0;
        int count =0;

        for (int i=0; i<nums.length;i++) {

            if (map.containsKey(nums[i])) {

                count = map.get(nums[i]);
                map.put(nums[i], count+1);
            }

            else {

                map.put(nums[i],1);
            }

            if (max < map.get(nums[i])) {

                max = map.get(nums[i]);
                majorityElement = nums[i];
            }
        }

        return majorityElement;

    }

    public int majorityElement1(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }
}