package practice.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/24 16:24
 */
public class PacificAtlanticWaterFlow {

    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m;
    int n;

    /**
     * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/description/
     *
     * @param matrix
     * @return
     */
    public List<int[]> pacificAtlantic(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        List<int[]> res = new ArrayList<>();
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, n - 1, canReachA);
            dfs(matrix, i, 0, canReachP);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, m - 1, i, canReachA);
            dfs(matrix, 0, i, canReachP);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    res.add(new int[] {i, j});
                }
            }
        }
        return res;
    }

    public void dfs(int[][] matrix, int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] direction : directions) {
            if (r + direction[0] < 0 || r + direction[0] >= m || c + direction[0] < 0 || c + direction[1] >= n
                || matrix[r][c] > matrix[r + direction[0]][c + direction[1]]) {
                continue;
            }
            dfs(matrix, r + direction[0], c + direction[1], canReach);
        }
    }

}

