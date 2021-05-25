package practice.search;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /**
     * https://leetcode-cn.com/problems/palindrome-partitioning/description/
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, new ArrayList<>(), res);
        return res;
    }


    public static void dfs(String s, List<String> values, List<List<String>> res) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(values));
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                values.add(s.substring(0, i+1));
                dfs(s.substring(i + 1), values, res);
                values.remove(values.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aabb"));
    }

}
