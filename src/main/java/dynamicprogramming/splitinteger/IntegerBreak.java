package dynamicprogramming.splitinteger;

/**
 * @author xifu.yy
 * @description 分割整数的最大乘积
 * @date 2021/02/23 19:40
 */
public class IntegerBreak {
    public static void main(String[] args) {
        integerBreak(6);
    }
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}