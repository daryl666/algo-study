package practice.bitoperation;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/15 19:13
 */
public class MissingNumber {
    /**
     * https://leetcode-cn.com/problems/missing-number/description/
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i] ^ i;
        }
        return res;
    }

}