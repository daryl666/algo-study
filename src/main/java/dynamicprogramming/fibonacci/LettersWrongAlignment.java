package dynamicprogramming.fibonacci;

/**
 * https://zhuanlan.zhihu.com/p/110754977
 *
 * @author xifu.yy
 * @description 有 N 个 信 和 信封，它们被打乱，求错误装信方式的数量。
 * @date 2021/02/23 15:50
 */
public class LettersWrongAlignment {
    public static void main(String[] args) {
        wrongAlignment(3);
    }

    public static int wrongAlignment(int letterNum) {
        if (letterNum < 2) {
            return 0;
        }
        if (letterNum == 2) {
            return 1;
        }
        int[] dp = new int[letterNum + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= letterNum; i++) {
            dp[i] = (letterNum - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[letterNum];
    }

}