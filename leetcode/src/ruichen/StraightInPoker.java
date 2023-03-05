package ruichen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StraightInPoker {
    /*
    Original question link: https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
    Randomly draw 5 cards from a deck of cards and decide whether they are a straight (consecutive) or not.
    A == 1, J == 11, Q == 12, K == 13, Jokers == 0 (seen as wildcard)
    Example input: [1,2,3,4,5], output: True
    Example input: [0,0,1,2,5], output: True
    */
    class Solution1 {
        // 1 2 3 4 5
        // 1 2 0 0 5
        // max - min < 5 && unique -> hash set
        // TC = O(5), SC = O(5)
        public boolean isStraight(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int min = 0;
            int max = 14;
            for (int num : nums) {
                if (set.contains(num)) {
                    return false;
                }
                if (num != 0) {
                    set.add(num);
                    min = Math.min(min, num);
                    max = Math.max(max, num);
                }
            }
            return max - min < 5;
        }
    }

    class Solution2 {
        // "brute force" sort
        // TC = O(5), SC = O(5)
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int zeros = 0, diffs = 0;
            while (nums[zeros] == 0) {
                zeros++;
            }
            for (int i = zeros; i < nums.length - 1; i++) {
                if (nums[i + 1] == nums[i]) {
                    return false;
                }
                int diff = nums[i + 1] - nums[i] - 1;
                diffs += diff;
            }
            return zeros >= diffs;
        }
    }
}
