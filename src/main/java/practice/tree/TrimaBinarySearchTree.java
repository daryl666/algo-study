package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/03 14:08
 */
public class TrimaBinarySearchTree {
    /**
     * https://leetcode-cn.com/problems/trim-a-binary-search-tree/description/
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        if (root.getValue() >= L && root.getValue() <= R) {
            TreeNode left = trimBST(root.getLeft(), L, R);
            TreeNode right = trimBST(root.getRight(), L, R);
            root.setLeft(left);
            root.setRight(right);
            return root;
        }
        if (root.getValue() < L) {
            return trimBST(root.getRight(), L, R);
        }

        if (root.getValue() > R) {
            return trimBST(root.getLeft(), L, R);
        }
        return root;
    }

}