package practice.twocursors;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/19 10:55
 */
public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[] {i, j};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {2, 7, 11, 15};
        System.out.println(twoSum(numbers, 9));
    }
}