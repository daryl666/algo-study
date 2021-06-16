package practice.string;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/08 18:49
 */
public class ValidAnagram {
    /**
     * https://leetcode-cn.com/problems/longest-palindrome/description/
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        int[] cnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            cnts[t.charAt(i) - 'a']--;
        }

        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }

}