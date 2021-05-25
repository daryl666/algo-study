package practice.greedyalgoirthm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/20 17:05
 */
public class PartitionLabels {
    /**
     * https://leetcode-cn.com/problems/partition-labels/description/
     * @param str
     * @return
     */
    public static List<Integer> partitionLabels(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < str.toCharArray().length; i++) {
            lastIndexOfChar[char2Int(str.charAt(i))] = i;
        }
        int firstIndex = -1;
        int lastIndex = lastIndexOfChar[char2Int(str.charAt(0))];
        List<Integer> partitions = new ArrayList<>();
        for (int i = 1; i < str.toCharArray().length; i++) {
            if (i == lastIndex) {
                partitions.add(lastIndex - firstIndex);
                firstIndex = i;
            }
            if (lastIndexOfChar[char2Int(str.charAt(i))] > lastIndex) {
                lastIndex = lastIndexOfChar[char2Int(str.charAt(i))];
            }
        }
        return partitions;
    }

    public static int char2Int(char c) {
        return c - 'a';
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}