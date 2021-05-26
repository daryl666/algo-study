package practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/26 16:06
 */
public class PerfectSquares {
    /**
     * https://leetcode-cn.com/problems/perfect-squares/description/
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        List<Integer> squares = buildSquares(n);
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (Integer square : squares) {
                if (i - square > 0) {
                    min = Math.min(min, dp[i - square] + 1);
                } else if (i == square) {
                    min = 1;
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static List<Integer> buildSquares(int n) {
        List<Integer> res = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square < n) {
            res.add(square);
            square += diff;
            diff += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

}