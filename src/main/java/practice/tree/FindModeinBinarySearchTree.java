package practice.tree;

import java.util.ArrayList;
import java.util.List;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/03 19:24
 */
public class FindModeinBinarySearchTree {
    int curCnt = 1;
    int maxCnt = 0;
    TreeNode pre;

    /**
     * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/description/
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        int[] nums = new int[res.size()];

        for (int i = 0; i < nums.length; i++) {
            nums[i++] = res.get(i);
        }
        return nums;
    }

    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft(), nums);
        if (pre != null) {
            if (pre.getValue() == root.getValue()) {
                curCnt++;
            } else {
                if (curCnt > maxCnt) {
                    nums.clear();
                    nums.add(root.getValue());
                    maxCnt = curCnt;
                } else if (curCnt == maxCnt) {
                    nums.add(root.getValue());
                }
                curCnt = 1;
            }
        }
        pre = root;
        inOrder(root.getRight(), nums);

    }



}