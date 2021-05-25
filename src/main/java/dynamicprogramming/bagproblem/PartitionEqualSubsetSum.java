package dynamicprogramming.bagproblem;

import java.util.Arrays;

/**
 * @author xifu.yy
 * @description 划分数组为和相等的两部分
 * @date 2021/04/06 19:24
 */
public class PartitionEqualSubsetSum {

    /**
     * Input: [1, 5, 11, 5]
     *
     * Output: true
     *
     * Explanation: The array can be partitioned as [1, 5, 5] and [11].
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        if (nums == null) {
            return false;
        }
        int sum = computeArraySum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[W];
    }

    private static int computeArraySum(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1, 5, 5, 11};
        canPartition(input);
    }
}