package practice.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/08 11:24
 */
public class ContainsDuplicate {
    /**
     * https://leetcode-cn.com/problems/contains-duplicate/description/
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }

}