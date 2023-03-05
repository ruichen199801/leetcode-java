package ruichen;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    // Hash map in place: TC = O(n), SC = O(1)
    // Same as #41, #448
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {

            List<Integer> res = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                nums[num - 1] = -nums[num - 1];
                if (nums[num - 1] > 0) { // two negatives make a positive
                    res.add(num); // num - 1 + 1 = num
                }
            }
            return res;
        }
    }
}
