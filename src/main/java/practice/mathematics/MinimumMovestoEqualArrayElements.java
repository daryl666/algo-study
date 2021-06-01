package practice.mathematics;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 17:05
 */
public class MinimumMovestoEqualArrayElements {
    /**
     * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii/description/
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        int res = 0;
        int middle = findKthSmallest(nums, nums.length / 2);
        for (int num : nums) {
            res += Math.abs(num - middle);
        }
        return res;
    }

    public int findKthSmallest(int[] nums, int k) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int pivot = partition(nums, i, j);
            if (pivot == k) {
                break;
            }
            if (pivot > k) {
                j = pivot - 1;
            } else {
                i = pivot + 1;
            }
        }
        return nums[k];
    }

    public int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        while (i < j) {
            while (nums[++i] < nums[l] && i < h) {}
            while (nums[--j] > nums[h] && j > l) {}
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}