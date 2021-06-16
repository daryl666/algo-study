package practice.arrayandmatrix;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/10 17:53
 */
public class BeautifulArrangement2 {
    /**
     * https://leetcode-cn.com/problems/beautiful-arrangement-ii/description/
     * 用前k个数先构造k个不同的差值
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1, intervel = k; i < k; i++, intervel--) {
            if (i % 2 == 1) {
                res[i] = res[i - 1] + intervel;
            } else {
                res[i] = res[i - 1] - intervel;
            }
        }
        for (int i = k; i < n; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}