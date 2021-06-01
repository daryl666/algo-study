package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/28 15:08
 */
public class BestTimetoBuyandSellStock {
    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/description/
     * 0 未进行任何操作
     * 1 进行一次买操作
     * 2 进行一次买 又卖
     * 3 进行第二次买
     * 4 进行第二次卖
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int[] dp = new int[5];
        dp[1] = -prices[0];
        // 可以同一天买入并卖出
        dp[3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
        }
        return dp[4];
    }

    public static void main(String[] args) {
        int[] prices = new int[] {2, 4, 1};
        System.out.println(maxProfit(prices));
    }

}