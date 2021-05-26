package practice.dynamicprogramming;

import java.util.Arrays;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/26 17:03
 */
public class LongestIncreasingSubsequence {
    /**
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

}