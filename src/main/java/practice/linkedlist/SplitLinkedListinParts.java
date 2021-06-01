package practice.linkedlist;

import domain.ListNode;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/01 16:34
 */
public class SplitLinkedListinParts {
    /**
     * https://leetcode-cn.com/problems/split-linked-list-in-parts/description/
     * 1 2 3 4 5 6 7 8
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        int cnt = 0;
        ListNode node = root;
        while (node != null) {
            cnt++;
            node = node.getNext();
        }
        int avg = cnt / k;
        int mod = cnt % k;
        ListNode[] res = new ListNode[k];
        int i = 0;
        // 1 2 3 4 5 6 7 8
        while (root != null) {
            int length = avg;
            if (mod-- > 0) {
                length++;
            }
            res[i] = root;
            while (--length > 0) {
                root = root.getNext();
            }
            ListNode temp = root.getNext();
            root.setNext(null);
            root = temp;
            i++;
        }
        return res;
    }

}