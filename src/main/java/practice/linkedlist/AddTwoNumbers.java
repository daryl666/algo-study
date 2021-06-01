package practice.linkedlist;

import java.util.Stack;

import domain.ListNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 14:46
 */
public class AddTwoNumbers {
    /**
     * https://leetcode-cn.com/problems/add-two-numbers-ii/description/
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = buildStack(l1);
        Stack<Integer> stack2 = buildStack(l2);
        int carry = 0;
        ListNode head = new ListNode(-1);
        while (!stack1.isEmpty() && !stack2.isEmpty() || carry != 0) {
            int x = !stack1.isEmpty() ? stack1.pop() : 0;
            int y = !stack2.isEmpty() ? stack2.pop() : 0;
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.setNext(head.getNext());
            head.setNext(node);
            carry = sum / 10;
        }
        return head.getNext();
    }

    Stack<Integer> buildStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.getValue());
            head = head.getNext();
        }
        return stack;
    }

}