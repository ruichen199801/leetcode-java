package ruichen;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak {
    class Solution1 {
        // Method 1: DFS + Memoization
        // TC = O(n^3) (2^n -> n^3), SC = O(n)
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            return dfs(s, dict, new Boolean[s.length()], 0);
        }

        private boolean dfs(String s, Set<String> dict, Boolean[] visited, int start) {
            if (start == s.length()) {
                return true;
            }
            if (visited[start] != null) {
                return visited[start];
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (dict.contains(s.substring(start, end)) && dfs(s, dict, visited, end)) {
                    visited[start] = true;
                    return visited[start];
                }
            }
            visited[start] = false;
            return false;
        }
    }

    class Solution2 {
        // Method 2: BFS

        // [c a t s a n d d o g], [cats dog sand and cat]
        //          0
        //      /       \
        //   3:cat      3:cats
        //     |         |
        //  7:sand      7:and
        //     |         |
        //  10:dog     10:dog

        // TC = O(n^3) (while loop * for loop * substring API), SC = O(n)
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[s.length()];
            queue.offer(0); // enqueue index
            visited[0] = true;
            while (!queue.isEmpty()) {
                int start = queue.poll();
                for (int end = start + 1; end <= s.length(); end++) {
                    String word = s.substring(start, end); // [l, r)
                    if (dict.contains(word)) {
                        if (end == s.length()) {
                            return true;
                        }
                        if (!visited[end]) {
                            queue.offer(end); // enqueue as next start
                            visited[end] = true;
                        }
                    }
                }
            }
            return false;
        }
    }

    class Solution3 {
        // Method 3: DP (Recommended)
        // TC = O(n^3) (nested for loop + substring), SC = O(n)
        public boolean wordBreak(String s, List<String> wordDict) {
            // record break point
            Set<String> dict = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true; // ""
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    String word = s.substring(j, i);
                    // check the sub-problem (dp[j]) and the rest of the word (s.substring(j, i))
                    // "left big section, right small section"
                    if (dp[j] && dict.contains(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
