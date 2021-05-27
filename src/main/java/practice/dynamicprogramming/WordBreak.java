package practice.dynamicprogramming;

import java.util.List;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/27 16:38
 */
public class WordBreak {
    /**
     * https://leetcode-cn.com/problems/word-break/description/
     * 单词必须按照顺序放入背包，因此外层对背包进行迭代，内部对物品进行迭代
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int length = word.length();
                if (i >= length && word.equals(s.substring(i - length, i))) {
                    dp[i] = dp[i] || dp[i - length];
                }
            }
        }
        return dp[s.length()];
    }

}