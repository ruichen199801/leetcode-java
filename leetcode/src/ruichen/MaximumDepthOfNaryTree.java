package ruichen;

import java.util.List;

public class MaximumDepthOfNaryTree {

    // #559 https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
    // Tree, Depth-first Search
    // TC = O(n), SC = O(n) (worst), O(log n) (balanced tree)

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    class Solution {
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            int[] depth = {0};
            for (Node child: root.children) {
                depth[0] = Math.max(maxDepth(child), depth[0]);
            }
            return depth[0] + 1;
        }
    }
}
