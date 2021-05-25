package practice.search;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * https://leetcode-cn.com/problems/subsets/description/
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, new ArrayList<>(), i, res, visited);
        }
        res.add(new ArrayList<>());
        return res;
    }

    public static void dfs(int[] nums, List<Integer> values, int cur, List<List<Integer>> res, boolean[] visited) {
        if (visited[cur]) {
            return;
        }
        values.add(nums[cur]);
        visited[cur] = true;
        res.add(new ArrayList<>(values));

        for (int i = cur; i < nums.length; i++) {
            dfs(nums, values, i, res, visited);
        }
        visited[cur] = false;
        values.remove(values.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }

}
