package practice.string;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/08 18:55
 */
public class LongestPalindrome {
    /**
     * 也可以用长度为256的数组存储字符的出现次数
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        }
        int[] uppercase = new int[26];
        int[] lowercase = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - 'a' >= 0 && c - 'a' <= 26) {
                lowercase[c - 'a']++;
            }
            if (c - 'A' >= 0 && c - 'A' <= 26) {
                uppercase[c - 'A']++;
            }
        }

        for (int i : uppercase) {
            if (i % 2 == 0) {
                res += i;
            } else if (i % 2 == 1 && i > 2) {
                res += i - 1;
            }
        }
        for (int i : lowercase) {
            if (i % 2 == 0) {
                res += i;
            } else if (i % 2 == 1 && i > 2) {
                res += i - 1;
            }
        }
        if (res < s.length()) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}