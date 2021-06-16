package practice.string;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/08 19:08
 */
public class IsomorphicStrings {
    /**
     * https://leetcode-cn.com/problems/isomorphic-strings/description/
     *
     * @param s
     * @return
     */
    public boolean isomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }
        int[] scArr = new int[256];
        int[] tcArr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (scArr[sc] != tcArr[tc]) {
                return false;
            }
            scArr[sc] = i;
            tcArr[tc] = i;
        }
        return true;
    }
}