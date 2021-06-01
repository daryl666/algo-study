package practice.linkedlist;

import domain.ListNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 10:33
 */
public class MergeTwoSortedLists {
    /**
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode preNode = new ListNode(-1);
        ListNode curNode = preNode;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curNode.setNext(l2);
                break;
            }
            if (l2 == null) {
                curNode.setNext(l1);
                break;
            }
            if (l1.getValue() < l2.getValue()) {
                curNode.setNext(l1);
                l1 = l1.getNext();
            } else {
                curNode.setNext(l2);
                l2 = l2.getNext();
            }
            curNode = curNode.getNext();
        }
        return preNode.getNext();
    }

}