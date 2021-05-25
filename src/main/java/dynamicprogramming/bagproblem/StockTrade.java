package dynamicprogramming.bagproblem;

/**
 * @author xifu.yy
 * @description 股票交易
 * @date 2021/04/12 20:13
 */
public class StockTrade {

    /**
     * 需要冷却期的股票交易
     * @param prices
     * @return
     */
    public int maxProfitWithCooldown(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] sell = new int[prices.length];
        int[] hold = new int[prices.length];
        sell[0] = 0;
        hold[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], hold[i - 1] + prices[i]);
            hold[i] = Math.max((i >= 2 ? sell[i - 2] : 0) - prices[i], hold[i - 1]);
        }
        return sell[prices.length - 1];
    }

    /**
     * 需要交易费的股票交易
     * @param prices
     * @return
     */
    public int maxProfitWithFee(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] sell = new int[prices.length];
        int[] hold = new int[prices.length];
        sell[0] = 0;
        hold[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], hold[i - 1] + prices[i] - fee);
            hold[i] = Math.max((i >= 1 ? sell[i - 1] : 0) - prices[i] -fee, hold[i - 1]);
        }
        return sell[prices.length - 1];
    }

    public static int maxProfitWith2Tradings(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int curPrice : prices) {
            if (firstBuy < -curPrice) {
                firstBuy = -curPrice;
            }
            if (firstSell < firstBuy + curPrice) {
                firstSell = firstBuy + curPrice;
            }
            if (secondBuy < firstSell - curPrice) {
                secondBuy = firstSell - curPrice;
            }
            if (secondSell < secondBuy + curPrice) {
                secondSell = secondBuy + curPrice;
            }
        }
        return secondSell;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {3, 3, 5, 0, 0, 3, 1, 4};
    }


}