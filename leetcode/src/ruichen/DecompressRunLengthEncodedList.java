package ruichen;

import java.util.ArrayList;
import java.util.List;

public class DecompressRunLengthEncodedList {

    // #1313 https://leetcode.com/problems/decompress-run-length-encoded-list/
    // Array
    // TC = O(n), SC = O(n)

    class Solution {
        public int[] decompressRLElist(int[] nums) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i += 2) {
                for (int j = 0; j < nums[i]; j++) {
                    res.add(nums[i + 1]);
                }
            }
            return res.stream().mapToInt(i->i).toArray(); // List<Integer> to int[]
        }
    }
}
