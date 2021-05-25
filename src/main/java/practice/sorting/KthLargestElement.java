package practice.sorting;

import java.util.PriorityQueue;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/19 14:55
 */
public class KthLargestElement {
    /**
     * 小顶堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * 快速选择
     * TODO
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        return partition(nums, 0, nums.length - 1, k);
    }

    private int partition(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int i = l, j = r;
        int pivot = nums[l];
        while (i < j) {
            while (nums[i++] < pivot && i < r) {

            }
            while (nums[j--] > pivot && j > l) {

            }
            swap(nums, i, j);
        }
        if (i > k) {
            return partition(nums, l, i - 1, k);
        } else if (i < k) {
            return partition(nums, i + 1, r, k);
        } else {
            return nums[i];
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}