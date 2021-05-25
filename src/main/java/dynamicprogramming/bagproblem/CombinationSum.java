package dynamicprogramming.bagproblem;

import java.util.Arrays;

/**
 * @author xifu.yy
 * @description 组合总和
 * @date 2021/04/07 17:39
 */
public class CombinationSum {

    /**
     * nums = [1, 2, 3]
     * target = 4
     *
     * The possible combination ways are:
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     *
     * Note that different sequences are counted as different combinations.
     *
     * Therefore the output is 7.
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    continue;
                }
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}