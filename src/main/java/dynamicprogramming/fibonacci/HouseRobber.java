package dynamicprogramming.fibonacci;

/**
 * @author xifu.yy
 * @description 题目描述：抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
 * @date 2021/02/23 15:28
 */
public class HouseRobber {

    /**
     * 定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
     * 由于不能抢劫邻近住户，如果抢劫了第 i -1 个住户，那么就不能再抢劫第 i 个住户，所以
     * dp[i] = max(dp[i-1],dp[i-2]+num[i])
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int pre1 = 0;
        int pre2 = 0;
        for (int num : nums) {
            pre2 = pre1;
            pre1 = Math.max(pre2 + num, pre1);
        }
        return pre1;
    }
}