package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 10:47
 */
public class EditDistance {
    /**
     * https://leetcode-cn.com/problems/edit-distance/description/
     * 考虑第i和j和字符是否相等
     * 一、相等
     * dp[i][j] = dp[i-1][j-1]
     * 二、不等
     * 1、删除
     * dp[i][j] = dp[i-1][j] + 1
     * 2、插入
     * dp[i][j] = dp[i][j-1] + 1
     * 3、修改
     * dp[i][j] = dp[i-1][j-1] + 1
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

}