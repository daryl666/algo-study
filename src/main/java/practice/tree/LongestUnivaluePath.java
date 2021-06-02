package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/02 15:34
 */
public class LongestUnivaluePath {
    int length = 0;
    /**
     * https://leetcode-cn.com/problems/longest-univalue-path/
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestUnilateralUnivaluePathWithRoot(root);
        return length;
    }

    /**
     * 包含根节点的单边的最长路径
     * @param root
     * @return
     */
    public int longestUnilateralUnivaluePathWithRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = longestUnilateralUnivaluePathWithRoot(root.getLeft());
        int right = longestUnilateralUnivaluePathWithRoot(root.getRight());
        int leftPath = root.getLeft() != null && root.getValue() == root.getLeft().getValue() ? left + 1 : 0;
        int rightPath = root.getRight() != null && root.getValue() == root.getRight().getValue() ? right + 1 : 0;
        length = Math.max(length, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }

}