package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/03 15:54
 */
public class ConvertBSTtoGreaterTree {

    private int sum = 0;
    /**
     * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/description/
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.getRight());
        sum += root.getValue();
        root.setValue(sum);
        dfs(root.getLeft());
    }

}