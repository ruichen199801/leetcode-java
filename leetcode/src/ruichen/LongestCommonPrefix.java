package ruichen;

public class LongestCommonPrefix {

    // #14 https://leetcode.com/problems/longest-common-prefix/
    // String (-> Trie)

    class Solution1 {
        public String longestCommonPrefix(String[] strs) {
            // Method 1: linear scan (best)
            // TC = O(n * m), n = length of string array, m = average length of string
            // SC = O(m), m = length of strs[0] -> substring() cost
            if (strs == null || strs.length == 0) {
                return " ";
            }
            for (int i = 0; i < strs[0].length(); i++) {
                char ch = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    // case 1: strs[0] always valid -> check NPE for each strs[j]
                    // case 2: character mismatch
                    if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                        return strs[0].substring(0, i); // [0, i)
                    }
                }
            }
            // reach this line: strs[0] itself is LCP
            return strs[0];
        }
    }

    class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            // Method 2: divide and conquer
            // TC = O(n * m)
            // SC = O(m * log n) as we are only storing "valid prefix" which is no longer than m in total

            // At every level, you manipulate half the strings as the previous time. Therefore, the sequence looks geometric:
            // 1 + 1/2 + 1/4 ... = 2
            // Except in this case it's: n * m + n/2 * m + n/4 * m ... = 2nm (time)
            // This calculation is less like merge sort (where each "level" is N steps) and more like the space of a binary tree (where each "level" is half as big as the one below it).
            // space is O(m*log n), log(n) stack levels are created and each level of the stack holds a prefix (O(m))

            if (strs == null || strs.length == 0) {
                return " ";
            }
            return partition(strs, 0, strs.length - 1);
        }

        private String partition(String[] strs, int left, int right) {
            // base case
            if (left >= right) {
                return strs[left];
            }
            int mid = left + (right - left) / 2;
            String leftPrefix = partition(strs, left, mid);
            String rightPrefix = partition(strs, mid + 1, right);
            return merge(leftPrefix, rightPrefix);
        }

        private String merge(String left, String right) {
            for (int i = 0; i < left.length(); i++) {
                char ch = left.charAt(i);
                if (i == right.length() || ch != right.charAt(i)) {
                    return left.substring(0, i);
                }
            }
            return left;
        }
    }

}
