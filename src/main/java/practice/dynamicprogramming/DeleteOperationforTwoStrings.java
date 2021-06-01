package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 10:32
 */
public class DeleteOperationforTwoStrings {
    /**
     * https://leetcode-cn.com/problems/delete-operation-for-two-strings/description/
     * 转换成求最长公共子序列
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        // 必须从1开始，否则i-1、j-1会越界
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }

}