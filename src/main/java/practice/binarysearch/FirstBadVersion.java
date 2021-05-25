package practice.binarysearch;

import java.util.Random;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/21 11:05
 */
public class FirstBadVersion {
    /**
     * https://leetcode-cn.com/problems/first-bad-version/description/
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int l = 1, h = n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (isBadVersion(mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean isBadVersion(int version) {
        return new Random().nextBoolean();
    }
}