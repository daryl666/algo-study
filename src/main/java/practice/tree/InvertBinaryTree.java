package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 19:03
 */
public class InvertBinaryTree {
    /**
     * https://leetcode-cn.com/problems/invert-binary-tree/description/
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.getLeft();
        root.setLeft(invertTree(root.getRight()));
        root.setRight(invertTree(left));
        return root;
    }

}