package practice.greedyalgoirthm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/19 17:22
 */
public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int preRight = Integer.MIN_VALUE;
        int cnt = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= preRight) {
                cnt++;
                preRight = interval[1];
            }
        }
        return intervals.length - cnt;
    }
}