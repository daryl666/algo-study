package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/27 11:41
 */
public class TargetSum {
    /**
     * https://leetcode-cn.com/problems/target-sum/description/
     * P-N=target
     * P-N-P=target-P
     * P-sum=target-P
     * 2P=target+sum
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + S) % 2 != 0) {
            return 0;
        }
        int n = (sum + S) / 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = n; i >= num; i--) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[n];
    }



}