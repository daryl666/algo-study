package dynamicprogramming.fibonacci;

/**
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * @author xifu.yy
 * @description 强盗在环形街区抢劫
 * @date 2021/02/23 15:40
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int first, int last) {
        int pre1 = 0;
        int pre2 = 0;
        for (int i = first; i <= last; i++) {
            pre2 = pre1;
            pre1 = Math.max(pre2 + nums[i], pre1);
        }
        return pre1;
    }
}