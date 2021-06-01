package domain;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/19 14:22
 */
public class ListNode {

    private ListNode next;

    private Integer value;

    public ListNode(Integer value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}