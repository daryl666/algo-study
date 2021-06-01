package practice.mathematics;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 19:19
 */
public class MajorityElement {
    /**
     * https://leetcode-cn.com/problems/majority-element/description/
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>(nums.length);
        int maxCnt = 0;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int curCnt = cntMap.getOrDefault(nums[i], 0) + 1;
            if (curCnt > maxCnt) {
                maxCnt = curCnt;
                maxIndex = i;
            }
            cntMap.put(nums[i], curCnt);
        }
        return nums[maxIndex];
    }

}