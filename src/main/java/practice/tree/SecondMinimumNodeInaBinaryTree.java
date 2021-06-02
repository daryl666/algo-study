package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/02 17:28
 */
public class SecondMinimumNodeInaBinaryTree {
    /**
     * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/description/
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.getLeft() != null && root.getRight() != null) {
            if (root.getLeft().getValue() > root.getRight().getValue()) {
                return root.getLeft().getValue();
            } else if (root.getLeft().getValue() < root.getRight().getValue()) {
                return root.getRight().getValue();
            } else {
                int left = findSecondMinimumValue(root.getLeft());
                int right = findSecondMinimumValue(root.getRight());
                if (left != -1 && right != -1) {
                    return Math.min(left, right);
                }
                if (left != -1) {
                    return left;
                }
                if (right != -1) {
                    return right;
                }
            }
        }
        return -1;
    }


}