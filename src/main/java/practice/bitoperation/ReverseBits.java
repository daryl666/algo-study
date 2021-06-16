package practice.bitoperation;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/16 10:09
 */
public class ReverseBits {
    /**
     * https://leetcode-cn.com/problems/reverse-bits/description/
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>>= 1;
        }
        return res;
    }

}