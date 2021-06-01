package practice.linkedlist;

import domain.ListNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 11:36
 */
public class RemoveDuplicatesfromSortedList {
    /**
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        while (curNode.getNext() != null) {
            if (curNode.getValue().equals(curNode.getNext().getValue())) {
                curNode.setNext(curNode.getNext().getNext());
                if (curNode.getNext() == null) {
                    break;
                }
                if (!curNode.getValue().equals(curNode.getNext().getValue())) {
                    curNode = curNode.getNext();
                }
            }
        }
        return head;
    }

}