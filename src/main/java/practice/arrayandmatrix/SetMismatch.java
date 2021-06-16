package practice.arrayandmatrix;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/10 11:16
 */
public class SetMismatch {
    /**
     * https://leetcode-cn.com/problems/set-mismatch/description/
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int dup = 0;
        int missing = 0;
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                dup = Math.abs(num);
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }

        return new int[] {dup, missing};
    }

}