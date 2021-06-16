package practice.arrayandmatrix;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/10 14:51
 */
public class FindtheDuplicateNumber {
    /**
     * https://leetcode-cn.com/problems/find-the-duplicate-number/description/
     * 二分查找
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int l = 1, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt < mid) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    /**
     * 类似于有环链表找入口
     * 快慢指针都指向第一个节点，慢指针一次走一步，快指针一次走两步，快慢指针会在环中相遇，这时候慢指针再指向第一个节点，快慢指针一起走，最后会相遇在环的入口
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 4, 1, 2};
        findDuplicate2(nums);
    }
}