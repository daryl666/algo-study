package dynamicprogramming.matrixpath;

import java.util.Arrays;

/**
 * @author xifu.yy
 * @description 统计从矩阵左上角到右下角的路径总数，每次只能向右或者向下移动。
 * @date 2021/02/23 17:40
 */
public class UniquePaths {
    public static void main(String[] args) {
        uniquePaths(3, 7);
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}