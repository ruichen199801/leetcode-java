package ruichen;

public class TwoSumII {

    class Solution {

        // #167 https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
        // Array, Two Pointers
        // TC = O(n), SC = O(1)

        public int[] twoSum(int[] numbers, int target) {
            int i = 0, j = numbers.length - 1;
            while (i < j) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {i + 1, j + 1};
                } else if (numbers[i] + numbers[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return new int[] {-1, -1};
        }

    }
}
