package practice.mathematics;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 16:31
 */
public class FactorialTrailingZeroes {
    /**
     * https://leetcode-cn.com/problems/factorial-trailing-zeroes/description/
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

}