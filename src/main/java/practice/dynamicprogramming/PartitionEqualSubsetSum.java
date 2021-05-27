package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/27 11:10
 */
public class PartitionEqualSubsetSum {
    /**
     * https://leetcode-cn.com/problems/partition-equal-subset-sum/description/
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i-1]] + nums[i-1]);
                }
            }
        }
        return dp[n][sum / 2] == sum / 2;

    }

    /**
     * 优化版
     * @param nums
     * @return
     */
    public static boolean canPartition2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int w = sum / 2;
        boolean[] dp = new boolean[w + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = w; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[w];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 5, 11, 5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition2(nums));
    }

}