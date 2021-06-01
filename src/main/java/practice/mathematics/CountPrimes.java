package practice.mathematics;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/31 15:01
 */
public class CountPrimes {
    /**
     * https://leetcode-cn.com/problems/count-primes/description/
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] isNotPrimes = new boolean[n + 1];
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isNotPrimes[i]) {
                continue;
            }
            cnt++;
            for (int j = i * i; j < n; j+=i) {
                isNotPrimes[j] = true;
            }
        }
        return cnt;
    }

}