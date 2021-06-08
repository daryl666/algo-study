package practice.stackandqueue;

import java.util.Stack;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/04 11:33
 */
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(Integer num) {
        if (stack.isEmpty()) {
            min.push(num);
        } else {
            min.push(Math.min(num, min.peek()));
        }
        stack.push(num);
    }

    public Integer pop() {
        min.pop();
        return stack.pop();
    }

    public Integer peek() {
        return stack.peek();
    }

    public Integer min() {
        return min.peek();
    }
}