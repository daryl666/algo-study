package practice.mathematics;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 16:40
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carrier = 0;
        StringBuilder sb = new StringBuilder();
        while (carrier > 0 || i >= 0 || j >= 0) {
            if (i >= 0 && a.charAt(i--) == '1') {
                carrier++;
            }
            if (j >= 0 && b.charAt(j--) == '1') {
                carrier++;
            }
            sb.append(carrier % 2);
            carrier /= 2;
        }
        return sb.reverse().toString();
    }

}