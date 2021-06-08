package practice.stackandqueue;

import java.util.Stack;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/04 14:13
 */
public class DailyTemperatures {
    /**
     * https://leetcode-cn.com/problems/daily-temperatures/description/
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return null;
        }
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.add(i);
        }
        return res;
    }

}