package practice.mathematics;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 16:56
 */
public class AddStrings {
    /**
     * https://leetcode-cn.com/problems/add-strings/description/
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = num1.charAt(i) - '0';
            int y = num1.charAt(j) - '0';
            carry = x + y + carry;
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

}