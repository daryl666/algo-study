package sort;

import java.util.PriorityQueue;

/**
 * @author xifu.yy
 * @description
 * @date 2021/02/07 10:39
 */
public class HeapSort {

    public static void main(String[] args) {

    }

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}