package ruichen;

import ruichen.common.TreeNode;

public class SmallestStringStartingFromLeaf {
    // TC = O(n), SC = O(n)
    class Solution {
        String res = "~"; // make this global, store anything > 'z' (Integer.MAX_VALUE)

        public String smallestFromLeaf(TreeNode root) {
            // Same as #257
            dfs(root, new StringBuilder());
            return res;
        }

        private void dfs(TreeNode root, StringBuilder cur) {
            if (root == null) {
                return;
            }
            cur.append((char) ('a' + root.val));
            if (root.left == null && root.right == null) {
                // building sb: abd -> we want dba
                cur.reverse();
                String curStr = cur.toString();
                if (res.compareTo(curStr) > 0) { // curStr < res, use compareTo() to compare the lexicographical order between two strings
                    res = curStr;
                }
                cur.reverse(); // resume building-sb mode
            }
            dfs(root.left, cur);
            dfs(root.right, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
