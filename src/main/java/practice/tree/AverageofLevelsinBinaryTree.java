package practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/02 19:15
 */
public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new PriorityQueue<>();
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int sum = 0;
            int k = queue.size();

            for (int i = 0; i < k; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                sum += node.getValue();
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            res.add((double)sum/k);
        }
        return res;
    }

}
