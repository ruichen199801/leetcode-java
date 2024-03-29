package ruichen;

import ruichen.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    /*
    The official LC solution is misleading in that it's expensive to pass in "" and
    perform string concatenation every time we enter a new dfs function, creating a new copy on heap.
    It's more efficient to use a StringBuilder to build the answer and dump it to result list when we reach the leaf node.
    It's just a bit tricky in Java syntax to do pairwise add-remove in StringBuilder in this particular problem.
    */

    // TC = O(n), SC = O(n)
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            dfs(root, new StringBuilder(), res);
            return res;
        }

        private void dfs(TreeNode root, StringBuilder cur, List<String> res) {
            if (root == null) {
                return;
            }
            int len = cur.length();
            if (root.left == null && root.right == null) {
                cur.append(root.val);
                res.add(cur.toString());
                cur.delete(len, cur.length());
            } else {
                cur.append(root.val + "->");
                dfs(root.left, cur, res);
                dfs(root.right, cur, res);
                cur.delete(len, cur.length());
            }
        }
    }
}
