package practice.arrayandmatrix;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/09 14:33
 */
public class ReshapetheMatrix {
    /**
     * https://leetcode-cn.com/problems/move-zeroes/description/
     * @param matrix
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] matrix, int r, int c) {
        int originRow = matrix.length;
        int originCol = matrix[0].length;
        if (originCol * originCol != r * c) {
            return matrix;
        }
        int[][] res = new int[r][c];
        int cur = 0;
        for (int i = 0; i < originRow; i++) {
            for (int j = 0; j < originCol; j++) {
                res[cur / r][cur % c] = matrix[i][j];
                cur++;
            }
        }
        return res;
    }
}