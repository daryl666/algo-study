package practice.arrayandmatrix;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/10 19:53
 */
public class MaxChunksToMakeSorted {
    /**
     * https://leetcode-cn.com/problems/max-chunks-to-make-sorted/description/
     * [4,3,2,1,0]
     * [0,1,2,3,4]
     * @param nums
     * @return
     */
    public static int maxChunksToMakeSorted(int[] nums) {
        int chunkNum = 0;
        int cur = 0;
        while (true) {
            int start = cur;
            int min = Integer.MAX_VALUE;
            int max = 0;
            while (cur < nums.length) {
                min = Math.min(min, nums[cur]);
                max = Math.max(max, nums[cur]);
                if (min == start && max == cur) {
                    cur++;
                    chunkNum++;
                    break;
                }
                cur++;
            }
            if (cur >= nums.length) {
                break;
            }
        }
        return chunkNum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 2, 3, 4};
        int[] nums1 = new int[] {4,3,2,1,0};
        System.out.println(maxChunksToMakeSorted(nums1));
    }
}