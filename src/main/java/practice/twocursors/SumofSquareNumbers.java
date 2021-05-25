package practice.twocursors;

/**
 * @author xifu.yy
 * @description 两数平方和
 * @date 2021/05/19 11:01
 */
public class SumofSquareNumbers {
    public static boolean judgeSquareSum(int target) {
        if (target <= 0) {
            return false;
        }
        int i = 0, j = (int)Math.sqrt(target);
        while (i < j) {
            int sum = i * i + j * j;
            if (sum == target) {
                return true;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(4));
    }
}