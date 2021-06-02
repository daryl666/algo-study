package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/02 15:24
 */
public class SumofLeftLeaves {
    int sum = 0;
    /**
     * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root.getLeft())) {
            return root.getLeft().getValue() + sumOfLeftLeaves(root.getRight());
        }
        return sumOfLeftLeaves(root.getLeft()) + sumOfLeftLeaves(root.getRight());

    }

    public boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.getLeft() == null && node.getRight() == null;
    }

}