package practice.bitoperation;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/15 19:09
 */
public class HammingDistance {
    /**
     * https://leetcode-cn.com/problems/hamming-distance/
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while (z != 0) {
            if ((z & 1) == 1) {
                cnt++;
            }
            z = z >> 1;
        }
        return cnt;
    }

}