package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/27 15:24
 */
public class CoinChange {
    /**
     * https://leetcode-cn.com/problems/coin-change/description/
     * 物品：硬币
     * 重量：面额
     * 价值：数量
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (j == coins[i]) {
                    dp[j] = 1;
                } else if (dp[j] == 0 && j > coins[i]) {
                    dp[j] = dp[j - coins[i]] + 1;
                } else if (dp[j] != 0 && j > coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

}