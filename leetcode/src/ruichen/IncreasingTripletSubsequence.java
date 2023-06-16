package ruichen;

public class IncreasingTripletSubsequence {
    class Solution {
        // greedy: keep track of 1st and 2nd min, return true if we find an element greater than both
        // TC = O(n), SC = O(1)
        public boolean increasingTriplet(int[] nums) {
            int firstMin = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num <= firstMin) { // NOT <: let equal case fall into the first two if-conditions
                    firstMin = num;
                } else if (num <= secondMin) {
                    secondMin = num;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
