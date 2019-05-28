package algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXX
 * @date 2019/5/28 11:13
 */
public class TwoSum {

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i=0; i<nums.length; i++) {
            int otherValue = target - nums[i];
            if (map.containsKey(otherValue)) {
                return new int[]{i, map.get(otherValue)};
            }
            map.putIfAbsent(nums[i],i);
        }
        throw new IllegalArgumentException("no solution found!");
    }
}
