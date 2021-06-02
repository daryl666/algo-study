package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/02 15:17
 */
public class MinimumDepthofBinaryTree {
    /**
     * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.getLeft());
        int right = minDepth(root.getRight());
        // 如果有一棵子树为空，那么深度就是另一棵子树+1
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }

}