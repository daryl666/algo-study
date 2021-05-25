package practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/19 16:04
 */
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>(4);
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }
        int cnt = 0;
        List<Integer> resultList = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            List<Integer> bucketNums = buckets[i];
            if (bucketNums == null) {
                continue;
            }
            for (Integer bucketNum : bucketNums) {
                resultList.add(bucketNum);
                cnt++;
            }
            if (cnt == k) {
                break;
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = resultList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
        int k = 3;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}