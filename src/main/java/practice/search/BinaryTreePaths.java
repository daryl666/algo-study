package practice.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/24 19:20
 */
public class BinaryTreePaths {
    /**
     * https://leetcode-cn.com/problems/binary-tree-paths/description/
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> values, List<String> res) {
        if (node == null) {
            return;
        }
        values.add(node.getValue());
        if (node.getLeft() == null && node.getRight() == null) {
            res.add(buildPath(values));
        } else {
            dfs(node.getLeft(), values, res);
            dfs(node.getRight(), values, res);
        }
        values.remove(values.size() - 1);
    }

    public String buildPath(List<Integer> values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            sb.append(values.get(i));
            if (i == values.size() - 1) {
                continue;
            }
            sb.append("->");
        }
        return sb.toString();
    }

}