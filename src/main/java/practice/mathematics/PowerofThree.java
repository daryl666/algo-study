package practice.mathematics;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 19:48
 */
public class PowerofThree {
    /**
     * https://leetcode-cn.com/problems/power-of-three/description/
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 2) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

}