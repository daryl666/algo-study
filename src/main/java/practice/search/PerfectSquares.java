package practice.search;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/21 16:53
 */
public class PerfectSquares {
    /**
     * https://leetcode-cn.com/problems/perfect-squares/description/
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n <= 1) {
            return 1;
        }
        List<Integer> squares = buildSquares(n);
        int cnt = 0;
        boolean[] marked = new boolean[n+1];
        marked[n] = true;
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            while (size-- > 0) {
                Integer num = queue.poll();
                for (Integer square : squares) {
                    if (num - square < 0) {
                        break;
                    }
                    if (num.equals(square)) {
                        return cnt;
                    }
                    if (marked[num]) {
                        continue;
                    }
                    marked[num] = true;
                    queue.add(num - square);
                }
            }
        }
        return -1;
    }

    public static List<Integer> buildSquares(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        int square = 1;
        int diff = 3;
        res.add(square);
        while (square + diff <= n) {
            res.add(square + diff);
            diff += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(buildSquares(9));
    }
}