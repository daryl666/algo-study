package practice.linkedlist;

import domain.ListNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 10:11
 */
public class IntersectionofTwoLinkedLists {
    /**
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.getNext();
            b = b == null ? headA : b.getNext();
        }
        return a;
    }

}