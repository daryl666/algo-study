package practice.mathematics;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 15:50
 */
public class Base16 {
    public String toHex(int num) {
        char[] letters = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(letters[num & 0b1111]);
            num >>= 4;
        }
        return sb.reverse().toString();
    }

}