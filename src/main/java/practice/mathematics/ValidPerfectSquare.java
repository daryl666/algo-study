package practice.mathematics;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 19:43
 */
public class ValidPerfectSquare {
    /**
     * https://leetcode-cn.com/problems/valid-perfect-square/description/
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int cur = 0;
        int diff = 1;
        while (cur < num) {
            cur += diff;
            if (cur == num) {
                return true;
            }
            diff += 2;
        }
        return false;
    }

}