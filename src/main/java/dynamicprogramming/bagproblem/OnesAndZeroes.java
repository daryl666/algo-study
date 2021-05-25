package dynamicprogramming.bagproblem;

/**
 * @author xifu.yy
 * @description 01 字符构成最多的字符串
 * @date 2021/04/06 20:19
 */
public class OnesAndZeroes {
    /**
     * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
     * Output: 4
     *
     * Explanation: There are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are "10","0001",
     * "1","0"
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int ones = 0;
            int zeros = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}