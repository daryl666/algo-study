package practice.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/08 11:25
 */
public class LongestHarmoniousSubsequence {
    /**
     * https://leetcode-cn.com/problems/longest-harmonious-subsequence/description/
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (Entry<Integer, Integer> entry : countMap.entrySet()) {
            Integer num = entry.getKey();
            if (countMap.containsKey(num+1)) {
                max = Math.max(max, num + countMap.get(num + 1));
            }
        }
        return max;
    }

}