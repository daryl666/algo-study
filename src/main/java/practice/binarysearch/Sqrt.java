package practice.binarysearch;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/20 17:42
 */
public class Sqrt {

    /**
     * https://leetcode-cn.com/problems/sqrtx/description/
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 0, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid >= x) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }
}