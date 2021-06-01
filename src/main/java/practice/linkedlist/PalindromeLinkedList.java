package practice.linkedlist;

import domain.ListNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 15:02
 */
public class PalindromeLinkedList {
    /**
     * https://leetcode-cn.com/problems/palindrome-linked-list/description/
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.getNext();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        if (fast != null) {
            slow = slow.getNext();
        }
        cut(head, slow);
        return isEqual(head, reverse(slow));

    }

    ListNode reverse(ListNode head) {
        // 1 2 3 4 5 6 7 8
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.getNext();
        while (cur != null && next != null) {
            cur.setNext(pre);
            pre = cur;
            cur = next;
            next = next.getNext();
        }
        return cur;
    }

    void cut(ListNode head, ListNode cut) {
        while (head.getNext() != cut) {
            head = head.getNext();
        }
        head.setNext(null);
    }

    boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (!l1.getValue().equals(l2.getValue())) {
                return false;
            }
        }
        return true;
    }

}