package ruichen;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // #169 https://leetcode-cn.com/problems/majority-element/
    // Array

    class Solution1 {
        // Hash Table: TC = O(n), SC = O(n)
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int num: nums) {
                count.put(num, count.getOrDefault(num, 0) + 1);
                if (count.get(num) > nums.length / 2) {
                    return num;
                }
            }
            return -1;
        }
    }

    class Solution2 {
        // Boyer-Moore Voting Algorithm: TC = O(n), SC = O(1)
        // randomly elect a major
        // ally: count++, enemy: count--, count == 0: re-elect
        public int majorityElement(int[] nums) {
            int major = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    major = nums[i];
                }
                if (nums[i] == major) {
                    count++;
                } else {
                    count--;
                }
            }
            return major;
        }
    }
}
