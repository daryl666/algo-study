package practice.search;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/24 14:47
 */
public class FriendCircles {
    /**
     * https://leetcode-cn.com/problems/friend-circles/description/
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int num = 0;
        int n = M.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                num++;
            }
        }
        return num;
    }

    public void dfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < M[i].length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(M, j, visited);
            }
        }
    }

}