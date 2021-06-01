package practice.mathematics;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 20:23
 */
public class MaximumProductofThreeNumbers {
    /**
     * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/description/
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums) {
        int max1 = 1;
        int max2 = 1;
        int max3 = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * max2 > max3) {
                max3 = nums[i] * max2;
            }
            if (nums[i] * max1 > max2) {
                max2 = nums[i] * max1;
            }
            if (nums[i] > max1) {
                max1 = nums[i];
            }

        }
        return max3;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 6,7,8,3, 4,5};
        System.out.println(maximumProduct(nums));
    }

}