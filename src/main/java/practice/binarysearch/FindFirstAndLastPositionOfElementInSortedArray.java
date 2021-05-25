package practice.binarysearch;

import java.util.Arrays;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/21 11:36
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int l = 0, h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return new int[] {l};
    }

    public static int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int l = 0, h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return new int[] {l-1};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 6)));
        System.out.println(Arrays.toString(searchRange2(nums, 7)));
    }

}