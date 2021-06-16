package practice.bitoperation;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/16 14:42
 */
public class BinaryNumberwithAlternatingBits {
    /**
     * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/description/
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        int a = (n ^ (n >> 1));
        return (a & (a + 1)) == 0;
    }

}