package practice.tree;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 19:48
 */
public class PathSum2 {

    int cnt = 0;

    /**
     * https://leetcode-cn.com/problems/path-sum-iii/description/
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumWithRoot(root, sum) + pathSum(root.getLeft(), sum) + pathSum(root.getRight(), sum);
    }

    public int pathSumWithRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.getValue() == sum) {
            res++;
        }
        return res + pathSumWithRoot(root.getLeft(), sum - root.getValue()) + pathSumWithRoot(root.getRight(),
            sum - root.getValue());
    }

}