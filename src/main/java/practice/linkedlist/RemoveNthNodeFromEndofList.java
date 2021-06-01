package practice.linkedlist;

import domain.ListNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 12:00
 */
public class RemoveNthNodeFromEndofList {
    /**
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (n-- > 0 && p2 != null) {
            p2 = p2.getNext();
        }
        if (p2 == null) {
            return head.getNext();
        }

        while (p2 != null && p2.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        p1.setNext(p1.getNext().getNext());
        return head;
    }

}