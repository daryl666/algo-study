package practice.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/26 17:20
 */
public class MaximumLengthofPairChain {
    /**
     * https://leetcode-cn.com/problems/maximum-length-of-pair-chain/description/
     * @param pairs
     * @return
     */
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            dp[i] = max;
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][] {{5,6},{1, 2}, {2, 3}, {3, 4}};
        System.out.println(findLongestChain(nums));
    }

}