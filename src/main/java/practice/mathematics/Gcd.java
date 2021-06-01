package practice.mathematics;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 15:14
 */
public class Gcd {
    /**
     * 如果 a 和 b 均为偶数，f(a, b) = 2*f(a/2, b/2);
     * 如果 a 是偶数 b 是奇数，f(a, b) = f(a/2, b);
     * 如果 b 是偶数 a 是奇数，f(a, b) = f(a, b/2);
     * 如果 a 和 b 均为奇数，f(a, b) = f(b, a-b);
     *
     * @param a
     * @param b
     * @return
     */
    int gcd2(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return 0;
        }
        if (isEven(a) && isEven(b)) {
            return 2 * gcd2(a >> 1, b >> 1);
        } else if (isEven(a)) {
            return gcd2(a >> 1, b);
        } else if (isEven(b)) {
            return gcd2(a, b >> 1);
        } else {
            return gcd2(b, a - b);
        }
    }

    boolean isEven(int a) {
        return a % 2 == 0;
    }

    /**
     * 令a = kb+r
     * d是a和b的公约数
     * r=a-kb，那么d也可以整除r
     * d也是b和r的公约数
     *
     * @param a
     * @param b
     * @return
     */
    int gcd(int a, int b) {
        return b == 0 ? 0 : gcd(b, a % b);
    }

    /**
     * @param a
     * @param b
     * @return
     */
    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}