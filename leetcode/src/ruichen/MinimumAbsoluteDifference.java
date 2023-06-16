package ruichen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    class Solution1 {
        // Two pass: TC = O(n log n) (for sorting), SC = O(n) (to store results)
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            List<List<Integer>> res = new ArrayList<>();
            int minDiff = Integer.MAX_VALUE;
            for (int i = 1; i < arr.length; i++) {
                minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
            }
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] == minDiff) {
                    res.add(Arrays.asList(arr[i - 1], arr[i]));
                }
            }
            return res;
        }
    }

    class Solution2 {
        // One pass: TC = O(n log n), SC = O(n)
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            List<List<Integer>> res = new ArrayList<>();
            int minDiff = Integer.MAX_VALUE;
            for (int i = 1; i < arr.length; i++) {
                int diff = arr[i] - arr[i - 1];
                if (diff < minDiff) {
                    minDiff = diff;
                    res.clear();
                }
                if (diff == minDiff) {
                    res.add(Arrays.asList(arr[i - 1], arr[i]));
                }
            }
            return res;
        }
    }
}
