package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/26 19:20
 */
public class bagproblem {
    /**
     * 0-1背包问题
     * @param W
     * @param N
     * @param weights
     * @param values
     * @return
     */
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[W][N];
        dp[0][0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < W; j++) {
                int w = weights[i];
                int v = values[i];
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[W - 1][N - 1];

    }

}