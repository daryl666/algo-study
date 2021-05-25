package sort;

/**
 * @author xifu.yy
 * @description 二分查找
 * @date 2021/02/08 10:38
 */
public class BinarySearch {

    /**
     * 二分查找的正常实现
     *
     * @param nums
     * @param key
     * @return
     */
    public int binarySearch(int[] nums, int key) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            // 避免加法溢出
            int m = l + (h - l) / 2;
            if (nums[m] == key) {
                return m;
            } else if (nums[m] > key) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    /**
     * 一个数 x 的开方 sqrt 一定在 0 ~ x 之间，并且满足 sqrt == x / sqrt。可以利用二分查找在 0 ~ x 之间查找 sqrt。
     *
     * 对于 x = 8，它的开方是 2.82842...，最后应该返回 2 而不是 3。在循环条件为 l <= h 并且循环退出时，h 总是比 l 小 1，也就是说 h = 2，l = 3，因此最后的返回值应该为 h 而不是 l。
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int l = 0;
        int h = x;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (m * m == x) {
                return m;
            } else if (m * m > x) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return h;
    }

    /**
     * 题目描述：给定一个有序的字符数组 letters 和一个字符 target，要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。
     *
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0;
        int h = letters.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }

    /**
     * 题目描述：一个有序数组只有一个数不出现两次，找出这个数。
     *
     * 要求以 O(logN) 时间复杂度进行求解，因此不能遍历数组并进行异或操作来求解，这么做的时间复杂度为 O(N)。
     *
     * 令 index 为 Single Element 在数组中的位置。在 index 之后，数组中原来存在的成对状态被改变。如果 m 为偶数，并且 m + 1 < index，那么 nums[m] == nums[m +
     * 1]；m + 1 >= index，那么 nums[m] != nums[m + 1]。
     *
     * 从上面的规律可以知道，如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为 [m + 2, h]，此时令 l = m + 2；如果 nums[m] != nums[m + 1]，那么
     * index 所在的数组位置为 [l, m]，此时令 h = m。
     *
     * 因为 h 的赋值表达式为 h = m，那么循环条件也就只能使用 l < h 这种形式。
     *
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }

    /**
     * 153. Find Minimum in Rotated Sorted Array (Medium)
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] < nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[] {-1, -1};
        } else {
            return new int[] {first, Math.max(first, last)};
        }
    }

    private static int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length; // 注意 h 的初始值
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] intArr = new int[] {5, 7, 7, 8, 8, 10};
        searchRange(intArr, 8);

    }

}