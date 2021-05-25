package practice.binarysearch;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/21 11:13
 */
public class FindMinimumInRotatedSortedArray {
    /**
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= nums[h]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3, 4, 5, 1};
        System.out.println(findMin(nums));
    }

}