package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/26 11:34
 */
public class HouseRobber {
    /**
     * https://leetcode-cn.com/problems/house-robber/description/
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i < nums.length + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i-1], dp[i - 1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,9,3,1};
        System.out.println(rob(nums));
    }

}