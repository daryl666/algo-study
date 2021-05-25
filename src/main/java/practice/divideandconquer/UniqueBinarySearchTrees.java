package practice.divideandconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/21 14:33
 */
public class UniqueBinarySearchTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 1) {
            return Arrays.asList(new TreeNode(n));
        }
        return generateSubTrees(1, n);
    }

    public List<TreeNode> generateSubTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateSubTrees(start, i - 1);
            List<TreeNode> right = generateSubTrees(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.setLeft(leftNode);
                    root.setRight(rightNode);
                    res.add(root);
                }
            }
        }
        return res;
    }

}