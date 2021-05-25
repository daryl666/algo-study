package practice.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    /**
     * https://leetcode-cn.com/problems/combination-sum-ii/description/
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            dfs(candidates, target, 0, i, new ArrayList<>(), res, visited);
        }

        return res;
    }

    public static void dfs(int[] candidates, int target, int curSum, int cur, List<Integer> values, List<List<Integer>> res, boolean[] visited) {
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        curSum += candidates[cur];
        values.add(candidates[cur]);
        if (curSum > target) {
            values.remove(values.size() - 1);
            curSum -= candidates[cur];
            visited[cur] = false;
            return;
        }
        if (curSum == target) {
            res.add(new ArrayList<>(values));
            values.remove(values.size() - 1);
            curSum -= candidates[cur];
            visited[cur] = false;
            return;
        }

        for (int i = cur; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            dfs(candidates, target, curSum, i, values, res, visited);
        }
        values.remove(values.size() - 1);
        curSum -= candidates[cur];
        visited[cur] = false;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(candidates, 8));
    }


}
