package practice.bitoperation;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/16 14:20
 */
public class Swap2Int {
    /**
     * 不用额外空间交换两个整数
     * @param a
     * @param b
     * @return
     */
    public int[] swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new int[] {a, b};
    }
}