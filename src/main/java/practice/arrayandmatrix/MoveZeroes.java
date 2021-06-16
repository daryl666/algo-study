package practice.arrayandmatrix;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/09 11:52
 */
public class MoveZeroes {
    /**
     * https://leetcode-cn.com/problems/move-zeroes/description/
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}