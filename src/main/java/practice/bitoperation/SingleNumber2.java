package practice.bitoperation;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/15 19:24
 */
public class SingleNumber2 {
    /**
     * https://leetcode-cn.com/problems/single-number-iii/description/
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        temp &= -temp;
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & temp) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

}