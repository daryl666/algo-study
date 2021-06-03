package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/03 16:13
 */
public class LowestCommonAncestorofaBinarySearchTree {

    /**
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.getValue() < root.getValue() && q.getValue() < root.getValue()) {
            return lowestCommonAncestor(root.getLeft(), p, q);
        }
        if (p.getValue() > root.getValue() && q.getValue() > root.getValue()) {
            return lowestCommonAncestor(root.getRight(), p, q);
        }
        return root;
    }

}