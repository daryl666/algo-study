package practice.linkedlist;

import domain.ListNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 14:05
 */
public class SwapNodesinPairs {
    /**
     * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
     * 1 2 3 4 5 6 7 8 9
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode res = head.getNext();
        ListNode pre = new ListNode(-1);
        ListNode cur = head;
        ListNode next = cur.getNext();
        while (cur != null) {
            cur.setNext(next.getNext());
            next.setNext(cur);
            pre.setNext(next);
            if (cur.getNext() == null || cur.getNext().getNext() == null) {
                break;
            }
            pre = cur;
            cur = cur.getNext();
            next = cur.getNext();
        }
        return res;
    }

}