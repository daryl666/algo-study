package dynamicprogramming.bagproblem;

import java.util.List;

/**
 * @author xifu.yy
 * @description 字符串按单词列表分割
 * @date 2021/04/07 17:28
 */
public class WordBreak {
    /**
     * s = "leetcode",
     * dict = ["leet", "code"].
     * Return true because "leetcode" can be segmented as "leet code".
     *
     * dict 中的单词没有使用次数的限制，因此这是一个完全背包问题。
     *
     * 该问题涉及到字典中单词的使用顺序，也就是说物品必须按一定顺序放入背包中
     * 求解顺序的完全背包问题时，对物品的迭代应该放在最里层，对背包的迭代放在外层，只有这样才能让物品按一定顺序放入背包中。
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int length = word.length();
                if (i >= length && s.substring(i - length, i).equals(word)) {
                    dp[i] = dp[i] || dp[i - length];
                }
            }
        }
        return dp[n];
    }
}