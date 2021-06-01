package practice.linkedlist;

import domain.ListNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 10:21
 */
public class ReverseLinkedList {
    /**
     * https://leetcode-cn.com/problems/reverse-linked-list/description/
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;
    }

}