package practice.twocursors;

import java.util.List;

/**
 * @author xifu.yy
 * @description 最长子序列
 * @date 2021/05/19 14:30
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || d == null || d.size() == 0) {
            return null;
        }
        String longestStr = "";
        for (String target : d) {
            if (longestStr.length() > target.length() || longestStr.compareTo(target) < 0) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestStr = target;
            }
        }
        return longestStr;
    }

    private static boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == target.length();
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        String target = "apple";
        System.out.println(isSubstr(s, target));
    }
}