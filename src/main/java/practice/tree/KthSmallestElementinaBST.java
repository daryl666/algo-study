package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/03 15:18
 */
public class KthSmallestElementinaBST {
    int cnt = 0;
    int val = 0;
    /**
     * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/description/
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    public void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft(), k);
        cnt++;
        if (cnt == k) {
            val = root.getValue();
            return;
        }
        inOrder(root.getRight(), k);
    }

}