package practice.search;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/24 11:52
 */
public class NumberofIslands {


    private int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    /**
     * https://leetcode-cn.com/problems/number-of-islands/description/
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int[] direction : directions) {
            dfs(grid, r + direction[0], c + direction[1]);
        }
    }

}
