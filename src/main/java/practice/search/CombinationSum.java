package practice.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/25 15:14
 */
public class CombinationSum {
    /**
     * https://leetcode-cn.com/problems/combination-sum/description/
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            dfs(candidates, new ArrayList<>(), 0, i, target, res);
        }
        return res;
    }

    public static void dfs(int[] candidates, List<Integer> values, int curSum, int cur, int target, List<List<Integer>> res) {
        values.add(candidates[cur]);
        curSum += candidates[cur];
        if (curSum > target) {
            values.remove(values.size() - 1);
            return;
        }
        if (curSum == target) {
            res.add(new ArrayList<>(values));
            curSum -= candidates[cur];
            values.remove(values.size() - 1);
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            dfs(candidates, values, curSum, i, target, res);
        }
        values.remove(values.size() - 1);
        curSum -= candidates[cur];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        System.out.println(combinationSum(nums, 7));
    }
}