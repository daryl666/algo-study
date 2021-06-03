package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/03 19:15
 */
public class MinimumAbsoluteDifferenceinBST {
    int min = Integer.MAX_VALUE;
    TreeNode preNode;
    /**
     * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/description/
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        if (preNode != null) {
            min = Math.min(preNode.getValue() - root.getValue(), min);
        }
        preNode = root;
        inOrder(root.getRight());
    }

}