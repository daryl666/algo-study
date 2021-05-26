package practice.dynamicprogramming;

import java.util.Arrays;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/26 15:41
 */
public class ArithmeticSlices {
    /**
     * https://leetcode-cn.com/problems/arithmetic-slices/description/
     *
     * @param A
     * @return
     */
    public static int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        dp[0] = dp[1] = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int cnt = 0;
        for (int i : dp) {
            cnt += i;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(nums));
    }

}