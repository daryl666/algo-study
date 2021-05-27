package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/27 16:30
 */
public class CoinChange2 {
    /**
     * https://leetcode-cn.com/problems/coin-change-2/description/
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (i == coin) {
                    dp[i] = 1;
                } else {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }

}