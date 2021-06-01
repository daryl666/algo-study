package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/28 15:29
 */
public class BestTimetoBuyandSellStock4 {
    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/description/
     *
     * @param k
     * @param prices
     * @return
     */
    public static int maxProfit(int k, int[] prices) {
        int[] dp = new int[2 * k + 1];
        for (int i = 0; i < dp.length; i++) {
            if (i % 2 == 1) {
                dp[i] = -prices[0];
            }
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j % 2 == 1) {
                    // 奇数买入
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                } else {
                    // 偶数卖出
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                }
            }
        }
        return dp[2 * k];
    }

    public static void main(String[] args) {
        int[] prices = new int[] {2, 4, 1};
        System.out.println(maxProfit(2, prices));
    }

}