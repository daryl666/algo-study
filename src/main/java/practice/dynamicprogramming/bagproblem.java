package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/26 19:20
 */
public class bagproblem {
    /**
     * TODO 背包问题变种
     *
     * 0-1背包问题
     *
     * @param W
     * @param N
     * @param weights
     * @param values
     * @return
     */
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[W + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                int w = weights[i];
                int v = values[i];
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[W][N];

    }

    /**
     * 01背包问题 空间优化
     *
     * @param W
     * @param N
     * @param weights
     * @param values
     * @return
     */
    public int knapsack2(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = W; j > 0; j--) {
                if (j >= weights[i]) {
                    dp[j] = Math.max(dp[j - weights[i]] + values[i], dp[j]);
                }
            }
        }
        return dp[W];
    }

}