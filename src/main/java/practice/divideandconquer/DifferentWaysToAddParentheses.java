package practice.divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/21 14:15
 */
public class DifferentWaysToAddParentheses {
    /**
     * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/description/
     *
     * @param input
     * @return
     */
    public static List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        if (input.length() == 1 && !"+".equals(input) && !"-".equals(input) && !"*".equals(input)) {
            res.add(Integer.valueOf(input));
        }
        for (int i = 0; i < input.toCharArray().length; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer leftRes : left) {
                    for (Integer rightRes : right) {
                        switch (c) {
                            case '+':
                                res.add(leftRes + rightRes);
                                break;
                            case '-':
                                res.add(leftRes - rightRes);
                                break;
                            case '*':
                                res.add(leftRes * rightRes);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
        System.out.println(diffWaysToCompute(input));
    }

}