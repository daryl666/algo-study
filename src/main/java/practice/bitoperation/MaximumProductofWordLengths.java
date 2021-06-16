package practice.bitoperation;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/16 15:11
 */
public class MaximumProductofWordLengths {
    /**
     * https://leetcode-cn.com/problems/maximum-product-of-word-lengths/description/
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] val = new int[n];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                val[i] |= 1 << (c - 'a');
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((val[i] & val[j]) != 0) {
                    continue;
                }
                res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }

}