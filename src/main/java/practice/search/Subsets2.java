package practice.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    /**
     * https://leetcode-cn.com/problems/subsets-ii/description/
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            dfs(nums, i, new ArrayList<>(), res, visited);
        }
        res.add(new ArrayList<>());
        return res;
    }

    public static void dfs(int[] nums, int cur, List<Integer> values, List<List<Integer>> res, boolean[] visited) {
        if (visited[cur]) {
            return;
        }

        values.add(nums[cur]);
        visited[cur] = true;
        res.add(new ArrayList<>(values));

        for (int i = cur; i < nums.length; i++) {
            if (i > 0 && nums[i-1] == nums[i] && !visited[i-1]) {
                continue;
            }
            dfs(nums, i, values, res, visited);
        }

        values.remove(values.size() - 1);
        visited[cur] = false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

}
