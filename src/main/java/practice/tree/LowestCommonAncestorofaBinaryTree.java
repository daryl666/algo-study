package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/03 17:44
 */
public class LowestCommonAncestorofaBinaryTree {
    /**
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (contains(root.getLeft(), p) && !contains(root.getRight(), p) && !contains(root.getLeft(), q) && contains(
            root.getRight(), q)) {
            return root;
        }
        if (contains(root.getLeft(), q) && !contains(root.getRight(), q) && !contains(root.getLeft(), p) && contains(
            root.getRight(), p)) {
            return root;
        }
        if (contains(root.getLeft(), q) && contains(root.getLeft(), p)) {
            return lowestCommonAncestor(root.getLeft(), p, q);
        }
        if (contains(root.getRight(), q) && contains(root.getRight(), p)) {
            return lowestCommonAncestor(root.getLeft(), p, q);
        }
        return null;
    }

    private boolean contains(TreeNode root, TreeNode targetNode) {
        if (root == null || targetNode == null) {
            return false;
        }
        if (root.getValue() == targetNode.getValue()) {
            return true;
        }
        return contains(root.getLeft(), targetNode) || contains(root.getRight(), targetNode);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.getLeft(), p, q);
        TreeNode right = lowestCommonAncestor(root.getRight(), p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        return left;
    }
}