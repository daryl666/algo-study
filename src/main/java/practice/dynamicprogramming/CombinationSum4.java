package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/27 18:56
 */
public class CombinationSum4 {
    /**
     * https://leetcode-cn.com/problems/combination-sum-iv/description/
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i < target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

}