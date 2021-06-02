package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/02 11:12
 */
public class SymmetricTree {
    /**
     * https://leetcode-cn.com/problems/symmetric-tree/description/
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.getLeft(), root.getRight());
    }

    public boolean isSymmetric(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (tree1.getValue() != tree2.getValue()) {
            return false;
        }
        return isSymmetric(tree1.getLeft(), tree2.getRight()) && isSymmetric(tree1.getRight(), tree2.getLeft());
    }

}