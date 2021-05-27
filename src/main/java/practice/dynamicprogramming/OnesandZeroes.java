package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/27 14:23
 */
public class OnesandZeroes {
    /**
     * https://leetcode-cn.com/problems/ones-and-zeroes/description/
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        int[] zeros = new int[strs.length];
        int[] ones = new int[strs.length];
        charCnt(strs, zeros, ones);
        for (int i = 0; i < strs.length; i++) {
            int zeroCnt = zeros[i];
            int oneCnt = ones[i];
            for (int j = m; j >= zeroCnt; j--) {
                for (int k = n; k >= oneCnt; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroCnt][k - oneCnt] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public void charCnt(String[] strs, int[] zeros, int[] ones) {
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zeros[i]++;
                } else if (c == '1') {
                    ones[i]++;
                }
            }
        }
    }

}