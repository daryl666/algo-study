package dynamicprogramming.fibonacci;

/**
 * @author xifu.yy
 * @description 假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
 * @date 2021/02/23 16:17
 */
public class CowProduction {

    public static void main(String[] args) {
        product(5);
    }
    /**
     * 第 i 年成熟的牛的数量为：
     * dp[i]=dp[i-1]+dp[i-3]
     * @param n
     * @return
     */
    public static int product(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        return dp[n];
    }
}