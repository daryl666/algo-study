package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 19:06
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.setValue(t1.getValue() + t2.getValue());
        t1.setLeft(mergeTrees(t1.left, t2.left));
        t1.setRight(mergeTrees(t1.right, t2.right));
        return t1;
    }

}