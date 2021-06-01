package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/28 11:36
 */
public class BestTimetoBuyandSellStockwithCooldown {
    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
     * dp[i][0] 第i天持有股票的最大收益
     * dp[i][1] 第i天不持有股票，处于冷冻期，最大收益
     * dp[i][2] 第i天不持有股票，不处于冷冻期，最大收益
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    /**
     * 空间优化
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[] dp = new int[3];
        dp[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp0 = dp[0];
            int temp1 = dp[1];
            int temp2 = dp[2];
            dp[0] = Math.max(temp0, temp2 - prices[i]);
            dp[1] = temp0 + prices[i];
            dp[2] = Math.max(temp1, temp2);
        }
        return Math.max(dp[1], dp[2]);

    }

}