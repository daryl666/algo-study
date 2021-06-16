package practice.arrayandmatrix;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/10 19:32
 */
public class ArrayNesting {
    /**
     * https://leetcode-cn.com/problems/array-nesting/description/
     * @param nums
     * @return
     */
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            int j = i;
            while (nums[j] != -1) {
                cnt++;
                int temp = nums[j];
                nums[j] = -1;
                j = temp;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}