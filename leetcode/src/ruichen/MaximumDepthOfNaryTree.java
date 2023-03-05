package ruichen;

import ruichen.common.Node;

public class MaximumDepthOfNaryTree {
    // TC = O(n), SC = O(n) (worst), O(log n) (balanced tree)
    class Solution {
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            int[] depth = {0};
            for (Node child : root.children) {
                depth[0] = Math.max(maxDepth(child), depth[0]);
            }
            return depth[0] + 1;
        }
    }
}
