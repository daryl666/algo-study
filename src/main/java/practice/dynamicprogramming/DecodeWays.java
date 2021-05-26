package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/26 16:31
 */
public class DecodeWays {
    /**
     * https://leetcode-cn.com/problems/decode-ways/description/
     *
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < s.length()+1; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("11106"));
    }

}