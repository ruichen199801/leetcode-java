package ruichen;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {
    class Solution1 {
        // Group by 0s and 1s
        // 110001111000000 -> [2, 3, 4, 6] -> sum(2, 3, 4)
        // TC = O(n), SC = O(n) (group array size, at worst)
        public int countBinarySubstrings(String s) {
            List<Integer> group = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                int count = 0;
                while (i < s.length() - 1 && s.charAt(i + 1) == s.charAt(i)) {
                    i++;
                    count++;
                }
                group.add(count + 1);
            }

            int res = 0;
            for (int i = 0; i < group.size() - 1; i++) {
                res += Math.min(group.get(i), group.get(i + 1));
            }
            return res;
        }
    }

    class Solution2 {
        // Optimize to O(1) space
        public int countBinarySubstrings(String s) {
            int res = 0;
            int pre = 0, cur = 0;
            for (int i = 0; i < s.length(); i++) {
                while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                    cur++;
                }
                cur++;
                res += Math.min(pre, cur);
                pre = cur;
                cur = 0;
            }
            return res;
        }
    }
}
