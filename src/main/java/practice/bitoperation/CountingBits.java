package practice.bitoperation;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/16 15:28
 */
public class CountingBits {
    /**
     * https://leetcode-cn.com/problems/counting-bits/description/
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

}