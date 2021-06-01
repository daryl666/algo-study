package practice.mathematics;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 19:54
 */
public class ProductofArrayExceptSelf {
    /**
     * https://leetcode-cn.com/problems/product-of-array-except-self/description/
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            product *= num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = product;
            } else {
                nums[i] = product / nums[i];
            }
        }
        return nums;
    }

}