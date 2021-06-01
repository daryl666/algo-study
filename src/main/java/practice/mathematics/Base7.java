package practice.mathematics;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 15:31
 */
public class Base7 {
    /**
     * https://leetcode-cn.com/problems/base-7/description/
     * @param num
     * @return
     */
    public static String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        String symbol = num < 0 ? "-" : "";
        num = Math.abs(num);
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        sb.append(symbol);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(-100));
    }



}