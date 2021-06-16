package practice.bitoperation;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/16 14:26
 */
public class PowerofTwo {
    /**
     * 如果是2的n次方，那么二进制中只有一个1
     * @param num
     * @return
     */
    public boolean isPowerOfTwo(int num) {
        if (num <= 0) {
            return false;
        }
        int cnt = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                cnt++;
            }
            num >>= 1;
        }
        return cnt == 1;
    }

    /**
     *
     * @param num
     * @return
     */
    public boolean isPowerOfTwo2(int num) {
        return num > 0 && (num & (num - 1)) == 0;
    }

    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        int cnt = 0;
        int index = 0;
        int i = 0;
        while (num != 0) {
            i++;
            if ((num & 1) == 1) {
                cnt++;
                index = i;
            }
            num >>= 1;
        }
        return cnt == 1 && index % 2 == 1;
    }
}