package practice.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/25 10:54
 */
public class Permutations2 {
    /**
     * https://leetcode-cn.com/problems/permutations-ii/description/
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            dfs(nums, i, new ArrayList<>(), res, visited);
        }
        return res;
    }

    public static void dfs(int[] nums, int cur, List<Integer> values, List<List<Integer>> res, boolean[] visited) {
        if (visited[cur]) {
            return;
        }
        values.add(nums[cur]);
        if (nums.length == values.size()) {
            res.add(new ArrayList<>(values));
            values.remove(values.size() - 1);
            return;
        }
        visited[cur] = true;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            dfs(nums, i, values, res, visited);
        }
        visited[cur] = false;
        values.remove(values.size() - 1);

    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2,3};
        System.out.println(permuteUnique(nums));
    }

}