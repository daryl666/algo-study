package practice.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author xifu.yy
 * @description 按照字符出现频率进行排序
 * @date 2021/05/19 16:32
 */
public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> frequencyForChars = new HashMap<>();
        for (char aChar : chars) {
            frequencyForChars.put(aChar, frequencyForChars.getOrDefault(aChar, 0) + 1);
        }
        List<Character>[] buckets = new ArrayList[chars.length + 1];
        for (Entry<Character, Integer> entry : frequencyForChars.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (Character character : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(character);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}