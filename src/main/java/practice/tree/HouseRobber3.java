package practice.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/02 16:15
 */
public class HouseRobber3 {

    Map<TreeNode, List<TreeNode>> visitMap = new HashMap<>();
    int max = 0;
    /**
     * https://leetcode-cn.com/problems/house-robber-iii/description/
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        dfs(root, new ArrayList<>(), 0);
        int max1 = max;
        max = 0;
        rob(root.getLeft());
        int max2 = max;
        max = 0;
        rob(root.getRight());
        int max3 = max;
        return Math.max(max1, max2 + max3);
    }

    /**
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     * @param root
     * @param cannotVisit
     * @param curCnt
     */
    public void dfs(TreeNode root, List<TreeNode> cannotVisit, int curCnt) {
        if (root == null) {
            return;
        }
        if (!cannotVisit.contains(root)) {
            cannotVisit.add(root.getLeft());
            cannotVisit.add(root.getRight());
            curCnt++;
        }
        max = Math.max(max, curCnt);
        dfs(root.getLeft(), cannotVisit, curCnt);
        dfs(root.getRight(), cannotVisit, curCnt);
    }

    Map<TreeNode, Integer> cache = new HashMap<>();

    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        int val1 = root.getValue();
        if (root.getLeft() != null) {
            val1 += rob2(root.getLeft().getLeft());
            val1 += rob2(root.getLeft().getRight());
        }
        if (root.getRight() != null) {
            val1 += rob2(root.getRight().getLeft());
            val1 += rob2(root.getRight().getRight());
        }
        int val2 = rob2(root.getLeft()) + rob2(root.getRight());
        cache.put(root, Math.max(val1, val2));
        return Math.max(val1, val2);
    }

}