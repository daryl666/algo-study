package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 17:25
 */
public class MaximumDepthofBinaryTree {
    /**
     * https://leetcode-cn.com/problems/balanced-binary-tree/description/
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight())) + 1;
    }

}