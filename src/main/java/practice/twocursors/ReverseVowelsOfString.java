package practice.twocursors;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author xifu.yy
 * @description 反转字符串中的元音字符
 * @date 2021/05/19 11:06
 */
public class ReverseVowelsOfString {
    private final static HashSet<Character> vowels = new HashSet<>(
        Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (vowels.contains(chars[i]) && vowels.contains(chars[j])) {
                swap(chars, i, j);
                i++;
                j--;
            } else if (vowels.contains(chars[i])) {
                j--;
            } else if (vowels.contains(chars[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String input = "leetcode";
        System.out.println(reverseVowels(input));

    }
}