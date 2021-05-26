package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/26 11:25
 */
public class ClimbingStairs {
    /**
     * https://leetcode-cn.com/problems/climbing-stairs/description/
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 3; i < n + 1; i++) {
            int temp = pre2;
            pre2 = pre1 + pre2;
            pre1 = temp;
        }
        return pre2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

}