package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/03 18:35
 */
public class ConvertSortedArraytoBinarySearchTree {
    /**
     * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.setLeft(sortedArrayToBST(nums, start, mid - 1));
        root.setRight(sortedArrayToBST(nums, mid + 1, end));
        return root;
    }

}