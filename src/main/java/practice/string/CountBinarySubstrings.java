package practice.string;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/09 11:12
 */
public class CountBinarySubstrings {
    private int cnt = 0;
    /**
     * https://leetcode-cn.com/problems/count-binary-substrings/description/
     * @param s
     * @return
     */
    public int countBinaryStrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendString(s, i, i + 1);
        }
        return cnt;
    }

    private void extendString(String s, int start, int end) {
        if (start == end) {
            return;
        }
        int preStart = start, preEnd = end;
        while (start >= 0 && end < s.length() && preStart == start && preEnd == end) {
            start--;
            end++;
            cnt++;
        }
    }


}