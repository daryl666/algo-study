package dynamicprogramming.matrixpath;

/**
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 *
 * @author xifu.yy
 * @description 求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。
 * @date 2021/02/23 16:49
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        };
        minPathSum(grid);
    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 && i > 0) {
                    // 只能从上侧走到该位置
                    dp[i][j] = dp[i - 1][j];
                } else if (i == 0 && j > 0) {
                    // 只能从左侧走到该位置
                    dp[i][j] = dp[i][j - 1];
                } else if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
                dp[i][j] += grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}