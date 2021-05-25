package practice.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/25 14:46
 */
public class Combinations {
    /**
     * https://leetcode-cn.com/problems/combinations/description/
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        for (int i = 1; i < n + 1; i++) {
            dfs(n, k, i, new ArrayList<>(), visited, res);
        }
        return res;
    }

    public static void dfs(int n, int k, int cur, List<Integer> values, boolean[] visited, List<List<Integer>> res) {
        if (visited[cur]) {
            return;
        }
        values.add(cur);
        if (values.size() == k) {
            res.add(new ArrayList<>(values));
            values.remove(values.size() - 1);
            return;
        }
        visited[cur] = true;
        for (int i = cur; i < n + 1; i++) {
            dfs(n, k, i, values, visited, res);
        }
        visited[cur] = false;
        values.remove(values.size() - 1);

    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

}