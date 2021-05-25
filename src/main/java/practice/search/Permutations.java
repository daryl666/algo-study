package practice.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/24 19:51
 */
public class Permutations {
    /**
     * https://leetcode-cn.com/problems/permutations/description/
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, new ArrayList<>(), visited, res);
        }
        return res;
    }

    public static void dfs(int[] nums, int cur, List<Integer> values, boolean[] visited, List<List<Integer>> res) {
        if (visited[cur]) {
            return;
        }
        values.add(nums[cur]);
        if (values.size() == nums.length) {
            res.add(new ArrayList<>(values));
            values.remove(values.size() - 1);
            return;
        }
        visited[cur] = true;
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, values, visited, res);
        }
        values.remove(values.size() - 1);
        visited[cur] = false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(permute(nums));
    }



}