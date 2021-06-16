package practice.bitoperation;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/15 19:11
 */
public class SingleNumber {
    /**
     * https://leetcode-cn.com/problems/single-number/description/
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}