package practice.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/24 17:16
 */
public class RestoreIPAddresses {
    static int[] length = new int[] {1, 2, 3};
    /**
     * https://leetcode-cn.com/problems/restore-ip-addresses/description/
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12) {
            return res;
        }
        restore(new ArrayList<>(), s, 0, res);
        return res;
    }

    public static void restore(List<String> words, String s, int preLength, List<String> res) {
        if (preLength > s.length() || words.size() > 4) {
            return;
        }
        if (preLength == s.length() && words.size() != 4) {
            return;
        }
        if (preLength != s.length() && words.size() == 4) {
            return;
        }
        if (preLength == s.length() && words.size() == 4) {
            res.add(words.toString());
            return;
        }
        for (int i : length) {
            if (preLength >= s.length() || preLength + i > s.length()) {
                continue;
            }
            if (Integer.valueOf(s.substring(preLength, preLength + i)) < 0 || Integer.valueOf(
                s.substring(preLength, preLength + i)) > 255) {
                continue;
            }
            if (i > 1 && s.charAt(preLength) == '0') {
                continue;
            }
            words.add(s.substring(preLength, preLength + i));
            preLength += i;
            restore(words, s, preLength, res);
            words.remove(words.size() - 1);
            preLength -= i;
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("010010"));
    }

}