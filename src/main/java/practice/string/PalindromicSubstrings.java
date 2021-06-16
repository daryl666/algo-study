package practice.string;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/08 19:19
 */
public class PalindromicSubstrings {
    private int cnt = 0;
    /**
     * https://leetcode-cn.com/problems/palindromic-substrings/description/
     * @param s
     * @return
     */
    public int countSubStrings(String s) {
        if (s == null) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            extendString(s, i, i);
            extendString(s, i, i + 1);
        }
        return cnt;
    }

    private void extendString(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }
}