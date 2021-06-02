package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/02 10:58
 */
public class SubtreeofAnotherTree {
    /**
     * https://leetcode-cn.com/problems/subtree-of-another-tree/description/
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSubtreeWithRoot(s, t) || isSubtree(s.getLeft(), t) || isSubtree(s.getRight(), t);
    }

    public boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.getValue() == t.getValue()) {
            return isSubtree(s.getLeft(), t.getLeft()) && isSubtree(s.getRight(), t.getRight());
        } else {
            return false;
        }
    }

}