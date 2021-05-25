package practice.greedyalgoirthm;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/20 11:43
 */
public class IsSubsequence {
    /**
     * https://leetcode-cn.com/problems/is-subsequence/description/
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return false;
        }
        int index = -1;
        for (char c : s.toCharArray()) {
            if (t.indexOf(c, index + 1) == -1) {
                return false;
            }
        }
        return true;
    }
}