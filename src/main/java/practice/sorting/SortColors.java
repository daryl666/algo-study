package practice.sorting;

import java.util.Arrays;

/**
 * TODO 加强
 * @author xifu.yy
 * @description
 * @date 2021/05/19 16:42
 */
public class SortColors {

    public static void sortColors(int[] nums) {
        int cur = 0, p0 = 0, p2 = nums.length - 1;
        while (cur < p2) {
            if (nums[cur] == 0) {
                swap(nums, cur, p0);
                cur++;
                p0++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, p2);
                cur++;
                p2--;
            } else {
                cur++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}