package dynamicprogramming.arrayinterval;

/**
 * @author xifu.yy
 * @description 数组区间和
 * @date 2021/02/23 19:02
 */
public class RangeSumQuery {
    private int[] sums;

    public RangeSumQuery(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}