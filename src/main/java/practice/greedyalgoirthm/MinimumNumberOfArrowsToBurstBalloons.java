package practice.greedyalgoirthm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/19 17:40
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparing(o -> o[1]));
        int preRight = Integer.MIN_VALUE;
        int cnt = 1;
        for (int[] point : points) {
            if (point[0] > preRight) {
                cnt++;
                preRight = point[1];
            }
        }
        return cnt;
    }
}