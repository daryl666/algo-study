package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/28 14:34
 */
public class TimetoBuyandSellStockwithTransactionFee {
    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
     * dp[i][0] 第i天持有股票的最大收益
     * dp[i][1] 第i天不持有股票的最大收益
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp0 = dp[0];
            int temp1 = dp[1];
            dp[0] = Math.max(temp0, temp1 - prices[i]);
            dp[1] = Math.max(temp1, temp0 + prices[i] - fee);
        }
        return Math.max(dp[0], dp[1]);
    }

    /**
     * 贪心算法
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit2(int[] prices, int fee) {
        int buy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                maxProfit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return maxProfit;
    }

}