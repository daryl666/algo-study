package practice.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/04 15:21
 */
public class NextGreaterElement2 {
    /**
     * https://leetcode-cn.com/problems/next-greater-element-ii/description/
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] nums2 = Arrays.copyOf(nums, length * 2);
        System.arraycopy(nums, 0, nums2, length, length);
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                Integer preIndex = stack.pop();
                res[preIndex] = nums[i % length];
            }
            if (i < length) {
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        int[] nums2 = Arrays.copyOf(nums, nums.length * 2);
        System.arraycopy(nums, 0, nums2, nums.length, nums.length);
        System.out.println(Arrays.toString(nums2));
    }

}