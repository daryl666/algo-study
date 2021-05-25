package dynamicprogramming.bagproblem;

/**
 * @author xifu.yy
 * @description 01背包问题
 * @date 2021/02/25 11:42
 */
public class BagProblem {
    /**
     * @param W       背包的容量
     * @param N       物品总数
     * @param weights 物品重量
     * @param values  物品价值
     * @return
     */
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    /**
     * 一维数组版本
     * @param W
     * @param N
     * @param weights
     * @param values
     * @return
     */
    public int knapsack2(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = W; j >= 1; j--) {
                if (j >= w) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        return dp[W];
    }
}