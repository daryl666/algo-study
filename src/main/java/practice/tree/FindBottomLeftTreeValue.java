package practice.tree;

import java.util.PriorityQueue;
import java.util.Queue;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/02 19:37
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new PriorityQueue<>();
        queue.add(root);
        int res = -1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res = node.getValue();
            queue.add(node.getRight());
            queue.add(node.getLeft());
        }
        return res;
    }

}