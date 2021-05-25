package practice.twocursors;

import domain.ListNode;

/**
 * @author xifu.yy
 * @description 判断链表是否存在环
 * @date 2021/05/19 14:21
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.getNext();
        while (slow != null && fast != null && fast.getNext() != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return false;
    }
}