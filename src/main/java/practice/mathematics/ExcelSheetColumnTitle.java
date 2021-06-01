package practice.mathematics;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 16:27
 */
public class ExcelSheetColumnTitle {
    /**
     * @param n
     * @return
     */
    public static String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        n--;
        return convertToTitle(n / 26) + (char)(n % 26 + 'A');
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
    }

}