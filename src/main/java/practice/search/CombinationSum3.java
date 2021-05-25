package practice.search;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    static int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    /**
     * https://leetcode-cn.com/problems/combination-sum-iii/description/
     * @param k
     * @param n
     * @return
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[9];
        for (int i = 0; i < numbers.length; i++) {
            dfs(k, n, i, 0, new ArrayList<>(), res, visited);
        }

        return res;
    }

    public static void dfs(int k, int n, int cur, int curSum, List<Integer> values, List<List<Integer>> res, boolean[] visited) {
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        curSum += numbers[cur];
        values.add(numbers[cur]);
        if (values.size() == k && curSum == n) {
            res.add(new ArrayList<>(values));
            values.remove(values.size() - 1);
            curSum -= numbers[cur];
            visited[cur] = false;
            return;
        }
        for (int i = cur; i < numbers.length; i++) {
            dfs(k, n, i, curSum, values, res, visited);
        }
        values.remove(values.size() - 1);
        curSum -= numbers[cur];
        visited[cur] = false;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

}
