package practice.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/24 17:05
 */
public class LetterCombinationsofaPhoneNumber {
    String[] letters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    /**
     * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        doCombine("", digits, combinations);
        return combinations;
    }

    public void doCombine(String prefix, String digits, List<String> combinations) {
        if (prefix.length() == digits.length()) {
            combinations.add(prefix);
            return;
        }
        String cur = letters[digits.charAt(prefix.length()) - '0'];
        for (int i = 0; i < cur.length(); i++) {
            prefix += cur.charAt(i);
            doCombine(prefix, digits, combinations);
            prefix = prefix.substring(0, prefix.length() - 1);
        }
    }

}