package practice.bitoperation;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/16 14:46
 */
public class NumberComplement {
    /**
     * https://leetcode-cn.com/problems/number-complement/description/
     * 计算补码
     * @param num
     * @return
     */
    public static int numberComplement(int num) {
        return ~num + 1;
    }

    public static void main(String[] args) {
        System.out.println(numberComplement(5));
    }
}