package ruichen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

    // #140 https://leetcode.com/problems/word-break-ii/
    // String, Hash Table, Depth-first Search

    class Solution {

        // Elegant classic DFS solution
        // Time = O(2^n * n^2 + m), Space = O(n + 2^n + m * l) (?)
        // n = length of the string, m = length of wordDict, l = average length of each word in wordDict
        // Time:
        // 2^n: "do we need to put a char or put a space at each pos": two possible states
        // n^2: for-loop * substring API
        // m: one-time convert list to set
        // Space:
        // n: recursion stack
        // 2^n: space on heap to store all states as results if all of them are valid
        // m * l: space needed for the wordDict set

        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            List<String> result = new ArrayList<>();
            dfs(s, new StringBuilder(), result, dict, 0);
            return result;
        }

        private void dfs(String s, StringBuilder cur, List<String> result, Set<String> dict, int start) {
            if (start == s.length()) {
                result.add(cur.toString());
                return;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                String word = s.substring(start, end);
                if (dict.contains(word)) {
                    if (start == 0) {
                        cur.append(word);
                    } else {
                        cur.append(" " + word);
                    }
                    dfs(s, cur, result, dict, end); // pass cur!
                    if (start == 0) {
                        cur.delete(cur.length() - (end - start), cur.length());
                    } else {
                        cur.delete(cur.length() - (end - start) - 1, cur.length());
                    }
                }
            }
        }
    }
}
