package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 11:16
 */
public class TwoKeysKeyboard {
    /**
     * https://leetcode-cn.com/problems/2-keys-keyboard/description/
     * 递归
     *
     * @param n
     * @return
     */
    public int minSteps(int n) {
        if (n <= 1) {
            return 0;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return i + minSteps(n / i);
            }
        }
        return n;
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int minSteps2(int n) {
        if (n <= 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }

    public static int minSteps3(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minSteps2(3));
        System.out.println(minSteps3(3));
    }
}