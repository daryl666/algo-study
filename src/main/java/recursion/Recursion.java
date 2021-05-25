package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/02/19 14:32
 */
public class Recursion {

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer leftInt : left) {
                    for (Integer rightInt : right) {
                        switch (c) {
                            case '+':
                                ways.add(leftInt + rightInt);
                                break;
                            case '-':
                                ways.add(leftInt - rightInt);
                                break;
                            case '*':
                                ways.add(leftInt * rightInt);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<TreeNode>();
        }
        return generateSubtrees(1, n);
    }

    private static List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (s > e) {
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; ++i) {
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.setLeft(left);
                    root.setRight(right);
                    res.add(root);
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        generateTrees(3);
    }

}