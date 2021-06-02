package practice.tree;

import java.util.ArrayList;
import java.util.List;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/02 19:43
 */
public class Traverse {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.getValue());
        res.addAll(preOrder(root.getLeft()));
        res.addAll(preOrder(root.getRight()));
        return res;
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inOrder(root.getLeft()));
        res.add(root.getValue());
        res.addAll(inOrder(root.getRight()));
        return res;
    }

    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inOrder(root.getLeft()));
        res.addAll(inOrder(root.getRight()));
        res.add(root.getValue());
        return res;
    }
}