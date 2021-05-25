package practice.greedyalgoirthm;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/20 16:34
 */
public class NondecreasingArray {
    /**
     * https://leetcode-cn.com/problems/non-decreasing-array/description/
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            cnt++;
            if (i - 2 >= 0 && nums[i] < nums[i - 2]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}