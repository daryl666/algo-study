package practice.bitoperation;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/16 14:57
 */
public class SumofTwoIntegers {
    /**
     * a ^ b 表示没有进位的和
     * (a & b) << 1 表示进位
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

}