package practice.arrayandmatrix;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/09 14:54
 */
public class KthSmallestElementinaSortedMatrix {
    /**
     * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
     * TODO 需要巩固
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            queue.offer(new int[] {0, i, matrix[0][i]});
        }

        for (int i = 0; i < k; i++) {
            int[] t = queue.poll();
            if (t[0] == m - 1) {
                continue;
            }
            queue.offer(new int[] {t[0] + 1, t[1], matrix[t[0] + 1][t[1]]});
        }
        return queue.poll()[3];

    }

    /**
     * 二分查找
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[m - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = smallCount(matrix, mid);
            if (cnt <= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int smallCount(int[][] matrix, int mid) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = matrix.length - 1;
        int j = 0;
        int cnt = 0;
        while (i >= 0 && i < m && j >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                cnt += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return cnt;
    }

}