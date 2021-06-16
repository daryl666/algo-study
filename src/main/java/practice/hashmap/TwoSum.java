package practice.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/04 16:43
 */
public class TwoSum {
    /**
     * https://leetcode-cn.com/problems/two-sum/description/
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = i;
                res[1] = map.get(nums[i]);
                break;
            }
            map.put(target - nums[i], i);
        }
        return res;
    }

}