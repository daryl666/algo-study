package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 18:54
 */
public class DiameterofBinaryTree {
    int max = 0;

    /**
     * https://leetcode-cn.com/problems/diameter-of-binary-tree/description/
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());
        max = Math.max(max, left + right);
        return Math.max(right, left) + 1;
    }

}