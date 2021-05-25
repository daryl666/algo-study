package practice.greedyalgoirthm;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/20 11:06
 */
public class BestTimeToBuyAndSellStock {
    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
     * 一次股票交易包含买入和卖出，只进行一次交易，求最大收益。
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return -1;
        }
        int preMinPrice = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - preMinPrice > maxProfit) {
                maxProfit = prices[i] - preMinPrice;
            }
            if (prices[i] < preMinPrice) {
                preMinPrice = prices[i];
            }
        }
        return maxProfit;
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
     * 可以进行多次交易，多次交易之间不能交叉进行，可以进行多次交易。
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return -1;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] - prices[i - 1] > 0) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}