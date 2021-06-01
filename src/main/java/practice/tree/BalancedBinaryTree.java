package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 17:26
 */
public class BalancedBinaryTree {
    private boolean result = true;

    /**
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        treeDepth(root);
        return result;
    }

    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = treeDepth(root.getLeft());
        int rightDepth = treeDepth(root.getRight());
        if (Math.abs(leftDepth - rightDepth) > 1) {
            result = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

}