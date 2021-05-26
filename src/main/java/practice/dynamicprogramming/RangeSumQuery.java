package practice.dynamicprogramming;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/26 15:19
 */
public class RangeSumQuery {

    private int[] sum;

    public RangeSumQuery(int[] nums) {
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j] - sum[i];
    }

}