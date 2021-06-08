package practice.stackandqueue;

import java.util.Queue;
import java.util.Stack;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/04 10:37
 */
public class ImplementQueueusingStacks {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(Integer num) {
        in.push(num);
    }

    public Integer poll() {
        in2Out();
        return out.pop();
    }

    public Integer peek() {
        in2Out();
        return out.peek();
    }

    public boolean isEmpty() {
        return !in.isEmpty() && !out.isEmpty();
    }

    private void in2Out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }




}