package practice.dynamicprogramming;

/**
 * 母牛生产问题
 * 假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
 * @author xifu.yy
 * @description
 * @date 2021/05/26 14:08
 */
public class CowBreeding {
    public static int cowBreed(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cowBreed(8));
    }
}