package practice.string;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/09 10:35
 */
public class PalindromeNumber {
    /**
     * https://leetcode-cn.com/problems/palindrome-number/description/
     * 将x分成前半部分和后半部分(后半部分需要翻转)
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        return x == right || x == right / 10;
    }
}