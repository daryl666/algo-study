package practice.graph;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/11 10:31
 */
public class IsGraphBipartite {
    /**
     * https://leetcode-cn.com/problems/is-graph-bipartite/description/
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !isBipartite(graph, i, colors, 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph, int cur, int[] colors, int color) {
        if (colors[cur] != 0) {
            return colors[cur] == color;
        }
        colors[cur] = color;
        for (int i : graph[cur]) {
            if (!isBipartite(graph, i, colors, -1 * color)) {
                return false;
            }
        }
        return true;
    }
}