package practice.arrayandmatrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/10 19:06
 */
public class DegreeofanArray {
    /**
     * https://leetcode-cn.com/problems/degree-of-an-array/description/
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> numCnt = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            numCnt.put(nums[i], numCnt.getOrDefault(nums[i], 0) + 1);
            firstIndex.putIfAbsent(nums[i], i);
            lastIndex.putIfAbsent(nums[i], i);
            max = Math.max(numCnt.getOrDefault(nums[i], 0) + 1, max);
        }

        int minLength = nums.length;
        for (Entry<Integer, Integer> entry : numCnt.entrySet()) {
            if (entry.getValue() == max) {
                minLength = Math.min(minLength, lastIndex.get(entry.getKey()) - firstIndex.get(entry.getKey()) + 1);
            }
        }
        return minLength;
    }
}