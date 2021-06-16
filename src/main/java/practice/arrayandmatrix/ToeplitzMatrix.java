package practice.arrayandmatrix;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/10 19:25
 */
public class ToeplitzMatrix {
    /**
     * https://leetcode-cn.com/problems/toeplitz-matrix/description/
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int r = 0, c = i;
            int value = matrix[r][c];
            while (r++ < m && c++ < n) {
                if (value != matrix[r][c]) {
                    return false;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            int r = i, c = 0;
            int value = matrix[r][c];
            while (r++ < m && c++ < n) {
                if (value != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}