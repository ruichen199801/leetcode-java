package ruichen;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    // #131 https://leetcode.com/problems/palindrome-partitioning/
    // Depth-first Search

    class Solution {

        public List<List<String>> partition(String s) {

            // DFS recursion tree:
            //               aab
            //      /         |         \
            //     a          aa         aab
            //    / \         |          (x)
            //   a   ab       b
            //   |   (x)
            //   b

            // arr    [a, a, b]
            // start   0
            // end     0
            // curr   []
            // result []

            // Time complexity = O(n * 2^n) -- 2^n: recursion tree, n: generate substring + isPalindrome (similar to #78 Subsets)
            // For each character in the string we have 2 choices to create new palindrom substrings,
            // one is to join with previous substring (for(...end++)),
            // and another is to start a new palindrom substring (dfs(..end+1..)),
            // thus in the worst case there are 2^N palindrom substrings where all cases are valid palindromes

            // Space complexity = O(n), n = length of the string

            List<List<String>> result = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return result;
            }
            char[] arr = s.toCharArray();
            List<String> curr = new ArrayList<>();
            helper(arr, 0, curr, result);
            return result;
        }

        private void helper(char[] arr, int start, List<String> curr, List<List<String>> result) {
            if (start == arr.length) {
                result.add(new ArrayList<>(curr)); // deep copy
                return;
            }
            for (int end = start; end < arr.length; end++) { // [start, end]: the partitioned substring on the current level
                if (isPalindrome(arr, start, end)) {
                    curr.add(new String(arr, start, end - start + 1)); // String(char[] array, start index, length)
                    helper(arr, end + 1, curr, result); // pass into next start index: start+(end-start+1) = end+1
                    curr.remove(curr.size() - 1);
                }
            }
        }

        private boolean isPalindrome(char[] arr, int i, int j) {
            while (i < j) {
                if (arr[i++] != arr[j--]) {
                    return false;
                }
            }
            return true;
        }
    }
}
