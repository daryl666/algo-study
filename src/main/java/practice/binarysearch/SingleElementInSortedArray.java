package practice.binarysearch;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/21 10:27
 */
public class SingleElementInSortedArray {
    /**
     * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/description/
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (mid % 2 == 1) {
                mid--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[mid + 1] == nums[mid]) {
                l = mid + 2;
            } else if (nums[mid + 1] != nums[mid]) {
                h = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 3, 3, 4, 4, 2,8, 8};
        System.out.println(singleNonDuplicate(nums));
    }

}