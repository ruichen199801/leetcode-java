package ruichen;

public class RangeAddition {

    // #370 https://leetcode.com/problems/range-addition/
    // Array, Prefix Sum
    // TC = O(n + k), SC = O(1)

    class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            // Prefix sum:
            // start index: arr[i] += val
            // end index + 1: arr[i] -= val

            // 1) put inc at startIndex allows the inc to be carried to the next index starting from startIndex when we do the sum accumulation
            // 2) put -inc at endIndex + 1 simply means cancel out the previous carry from the next index of the endIndex, because the previous carry should not be counted beyond endIndex
            // 3) finally, because each of the update operation is independent and the list operation is just an accumulation of the "marks" we do, so it can be "marked" all at once first and do the range sum at one time at last step.

            // length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
            // -2 0 3 5 3
            // sum = 5
            int[] arr = new int[length];
            for (int[] update : updates) {
                int start = update[0], end = update[1], val = update[2];
                arr[start] += val;
                if (end + 1 < length) {
                    arr[end + 1] -= val;
                }
            }
            int prefixSum = 0;
            for (int i = 0; i < length; i++) {
                prefixSum += arr[i];
                arr[i] = prefixSum;
            }
            return arr;
        }
    }
}
