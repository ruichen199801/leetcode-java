package ruichen;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    // Classic DFS with two conditions to decide where it ends:
    // DFS ends when we have 4 ips, and when we reach the last character of the string
    // TC = O(3 * 3 * 3) = O(27) = O(1), SC = O(1)
    // if a dot is already placed: next dot: 1, 2, 3 chars away
    // the first dot only has 3 positions to choose from as well
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            dfs(s, new StringBuilder(), result, 0, 0);
            return result;
        }

        private void dfs(String s, StringBuilder cur, List<String> result, int index, int level) {
            // index: beginning index of the string to make ip
            // level: n-th ip we've made so far
            if (index > s.length() || level > 4) {
                return;
            }
            if (index == s.length() && level == 4) { // 0, 1, 2, 3
                result.add(cur.toString());
                return;
            }
            for (int i = 1; i <= 3; i++) {
                if (i + index > s.length()) {
                    break;
                }
                String ip = s.substring(index, index + i); // [l, r)
                if (isValid(ip)) {
                    // remember to backtrack: add-delete pair (check out word break problem)
                    cur.append(ip);
                    if (level < 3) {
                        cur.append('.');
                    }
                    dfs(s, cur, result, index + i, level + 1);
                    if (level < 3) {
                        cur.deleteCharAt(cur.length() - 1);
                    }
                    cur.delete(cur.length() - i, cur.length()); // [l, r)
                }
            }
        }

        private boolean isValid(String s) {
            if (s.length() == 0 || s.length() > 3 || Integer.parseInt(s) > 255 || (s.charAt(0) == '0' && s.length() > 1)) {
                return false;
            }
            return true;
        }
    }
}
