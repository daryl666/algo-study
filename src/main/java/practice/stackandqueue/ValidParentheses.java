package practice.stackandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/04 11:40
 */
public class ValidParentheses {
    /**
     * https://leetcode-cn.com/problems/valid-parentheses/description/
     * ()[]{}
     * {[]}
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            if (c == ']' && stack.peek() == '[') {
                stack.pop();
                continue;
            }
            if (c == '}' && stack.peek() == '{') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                boolean b1 = c == ')' && pop != '(';
                boolean b2 = c == ']' && pop != '[';
                boolean b3 = c == '}' && pop != '{';
                if (b1 || b2 || b3) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}