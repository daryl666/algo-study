package practice.twocursors;

import java.util.Arrays;

/**
 * @author xifu.yy
 * @description 归并两个有序数组
 * @date 2021/05/19 11:57
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, cur = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0 && j >= 0) {
                nums1[cur--] = nums2[j--];
                continue;
            }
            if (j < 0 && i >= 0) {
                nums1[cur--] = nums1[i--];
                continue;
            }
            if (nums1[i] >= nums2[j]) {
                nums1[cur--] = nums1[i--];
            } else {
                nums1[cur--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[] {2, 5, 6};
        merge(nums1, 3, nums2,3);
        System.out.println(Arrays.toString(nums1));

    }
}