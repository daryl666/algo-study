package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xifu.yy
 * @description
 * @date 2021/02/07 14:17
 */
public class BucketSort {
    public static void main(String[] args) {

    }

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (Integer num : frequency.keySet()) {
            if (buckets[frequency.get(num) - 1] == null) {
                buckets[frequency.get(num) - 1] = new ArrayList<>();
            }
            buckets[frequency.get(num) - 1].add(num);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (k > topK.size() + buckets[i].size()) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < topK.size(); i++) {
            result[i] = topK.get(i);
        }
        return result;
    }
}