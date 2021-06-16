package practice.arrayandmatrix;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/09 14:46
 */
public class Searcha2DMatrix {
    /**
     * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/description/
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length - 1;
        while (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}