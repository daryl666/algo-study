package practice.arrayandmatrix;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/09 14:41
 */
public class MaxConsecutiveOnes {
    /**
     * https://leetcode-cn.com/problems/max-consecutive-ones/description/
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int num : nums) {
            if (num == 1) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 0;
            }
        }
        return max;
    }
}