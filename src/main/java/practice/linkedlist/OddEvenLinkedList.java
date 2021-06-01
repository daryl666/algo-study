package practice.linkedlist;

import domain.ListNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 17:07
 */
public class OddEvenLinkedList {
    /**
     * https://leetcode-cn.com/problems/odd-even-linked-list/description/
     * 1 2 3 4 5 6 7 8 9
     * 1 3 5 7 2 4 6 8
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = head;
        ListNode evenHead = head.getNext();
        ListNode l1 = oddHead;
        ListNode l2 = evenHead;

        while (l1 != null && l2 != null && l1.getNext() != null && l2.getNext() != null) {
            l1.setNext(l2.getNext());
            l1 = l2.getNext();
            l2.setNext(l1.getNext());
            l2 = l1.getNext();
        }
        oddHead.setNext(evenHead);
        return oddHead;
    }

}