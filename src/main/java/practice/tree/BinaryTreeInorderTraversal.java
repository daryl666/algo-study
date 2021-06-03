package practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/02 20:18
 */
public class BinaryTreeInorderTraversal {
    /**
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        nodeList.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (nodeList.contains(node)) {
                nodeList.remove(node);
                if (node.getRight() != null) {
                    stack.push(node.getRight());
                    nodeList.add(node.getRight());
                }
                stack.push(node);
                if (node.getLeft() != null) {
                    stack.push(node.getLeft());
                    nodeList.add(node.getLeft());
                }
            } else {
                res.add(node.getValue());
            }
        }
        return res;
    }

}