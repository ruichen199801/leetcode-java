package ruichen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    // TC = O(nk), SC = O(nk)
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strings) {
                String pattern = computePattern(str);
                if (!map.containsKey(pattern)) {
                    map.put(pattern, new ArrayList<>());
                }
                map.get(pattern).add(str);
            }
            return new ArrayList<>(map.values());
        }

        private String computePattern(String str) {
            StringBuilder res = new StringBuilder();
            for (int i = 1; i < str.length(); i++) {
                int prev = str.charAt(i - 1) - 'a';
                int curr = str.charAt(i) - 'a';
                int shift = curr - prev > 0 ? curr - prev : curr - prev + 26;
                res.append(shift + ',');
            }
            return res.toString();
        }
    }
}
