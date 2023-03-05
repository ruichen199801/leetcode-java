package ruichen;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    // TC = O(n), SC = O(1), same as #41
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    res.add(i + 1);
                }
            }
            return res;
        }
    }
}
