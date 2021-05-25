package practice.search;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/21 16:31
 */
public class ShortestPathInBinaryMatrix {
    /**
     * https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
     *
     * @param grids
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grids) {
        if (grids == null) {
            return -1;
        }
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new PriorityQueue<>();
        queue.add(new int[] {0, 0});
        int m = grids.length;
        int n = grids[0].length;
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                int[] cur = queue.poll();
                int cr = cur[0];
                int cc = cur[1];
                if (grids[cr][cc] == 1) {
                    continue;
                }
                grids[cr][cc] = 1;
                if (cr == m - 1 && cc == n - 1) {
                    return pathLength;
                }
                for (int[] direction : directions) {
                    int nr = cr + direction[0];
                    int nc = cc + direction[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    queue.add(new int[] {nr, nc});
                }
            }
        }
        return -1;
    }

}