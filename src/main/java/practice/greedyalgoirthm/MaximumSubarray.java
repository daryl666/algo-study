package practice.greedyalgoirthm;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/20 16:47
 */
public class MaximumSubarray {
    /**
     * https://leetcode-cn.com/problems/maximum-subarray/description/
     * 动态规划
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i++) {
            preSum = Math.max(preSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}