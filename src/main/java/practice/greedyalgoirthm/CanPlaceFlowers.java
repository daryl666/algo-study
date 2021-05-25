package practice.greedyalgoirthm;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/20 11:20
 */
public class CanPlaceFlowers {
    /**
     * https://leetcode-cn.com/problems/can-place-flowers/description/
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        int length = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == length - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                cnt++;
            }
        }
        return cnt >= n;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(input, 1));
    }
}