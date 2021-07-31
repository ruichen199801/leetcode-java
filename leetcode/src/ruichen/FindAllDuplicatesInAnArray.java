package ruichen;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    // #442 https://leetcode.com/problems/find-all-duplicates-in-an-array/
    // Array

    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            // Same as #41 #448
            // HashMap in situ: TC = O(n), SC = O(1)
            List<Integer> res = new ArrayList<>();
            int n = nums.length; // 1 <= nums[i] <= n
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                nums[num - 1] = -nums[num - 1];
                // two negatives make a positve
                if (nums[num - 1] > 0) {
                    res.add(num); // num - 1 + 1 = num
                }
            }
            return res;
        }
    }
}
