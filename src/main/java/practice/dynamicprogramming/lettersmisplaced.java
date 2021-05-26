package practice.dynamicprogramming;

/**
 * 信件错排问题
 * 有 N 个 信 和 信封，它们被打乱，求错误装信方式的数量。
 * @author xifu.yy
 * @description
 * @date 2021/05/26 14:05
 */
public class lettersmisplaced {

    public int misplace(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = (i - 1) * dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }
}