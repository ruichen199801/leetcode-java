package ruichen;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    // #22 https://leetcode.com/problems/generate-parentheses/
    // Depth-first Search
    // TC = O(2^(2n) * n), SC = O(n)

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            dfs(n, 0, 0, result, new StringBuilder());
            return result;
        }

        private void dfs(int n, int l, int r, List<String> result, StringBuilder cur) {
            if (l == n && r == n) { // r == n
                result.add(cur.toString());
                return;
            }
            if (l < n) {
                cur.append('(');
                dfs(n, l + 1, r, result, cur);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (r < l) {
                cur.append(')');
                dfs(n, l, r + 1, result, cur);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}
