package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 19:35
 */
public class PathSum {

    boolean result = false;
    /**
     * https://leetcode-cn.com/problems/path-sum/description/
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return result;
    }

    public void dfs(TreeNode root, int sum) {
        //              5
        //             / \
        //            4   8
        //           /   / \
        //          11  13  4
        //         /  \      \
        //        7    2      1
        if (root == null) {
            if (sum == 0) {
                result = true;
            }
            return;
        }
        sum -= root.getValue();
        dfs(root.getLeft(), sum);
        dfs(root.getRight(), sum);
    }

}