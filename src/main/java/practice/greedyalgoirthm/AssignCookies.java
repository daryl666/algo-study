package practice.greedyalgoirthm;

import java.util.Arrays;

/**
 * @author xifu.yy
 * @description 分配饼干
 * @date 2021/05/19 17:10
 */
public class AssignCookies {
    public int findContentChildren(int[] grid, int[] size) {
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0;
        int si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    public static void main(String[] args) {

    }

}