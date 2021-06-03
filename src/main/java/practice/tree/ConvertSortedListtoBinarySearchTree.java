package practice.tree;

import domain.ListNode;
import recursion.Model.TreeNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/03 18:41
 */
public class ConvertSortedListtoBinarySearchTree {
    /**
     * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/description/
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null) {
            return new TreeNode(head.getValue());
        }
        ListNode preMid = preMid(head);
        ListNode mid = preMid.getNext();
        // 断开链表
        preMid.setNext(null);
        TreeNode t = new TreeNode(mid.getValue());
        t.setLeft(sortedListToBST(head));
        t.setRight(sortedListToBST(mid.getNext()));
        return t;
    }

    public ListNode preMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.getNext();
        ListNode pre = head;
        while (fast != null && fast.getNext() != null) {
            pre = slow;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return pre;
    }

}