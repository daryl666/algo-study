package practice.tree;

import java.util.ArrayList;
import java.util.List;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/03 19:02
 */
public class TwoSum4 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> sequence = inOrder(root);

        int i = 0, j = sequence.size() - 1;
        while (i < j) {
            if (sequence.get(i) + sequence.get(j) == k) {
                return true;
            }
            if (sequence.get(i) + sequence.get(j) > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            res.add(root.getValue());
            return res;
        }
        res.addAll(inOrder(root.getLeft()));
        res.add(root.getValue());
        res.addAll(inOrder(root.getRight()));
        return res;
    }

    public void inOrder2(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            nums.add(root.getValue());
            return;
        }
        inOrder2(root.getLeft(), nums);
        nums.add(root.getValue());
        inOrder2(root.getRight(), nums);
    }
}