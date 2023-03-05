package ruichen;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTreeIII {
    // (Premise: same as #236, p and q on root)
    // same as #160 find intersection, TreeNode with parent pointer -> ListNode with next pointer
    //              lca
    //              / \                      p -> p
    //            p     q                          \
    //           / \   / \        =>                lca
    //          p  x  q   x                        /
    //               / \                q -> q -> q
    //              q   x
    class Solution1 {
        // Method 1: use a hash set to store the path from p/q to root, the first common point of the two paths is LCA
        // TC = O(n), SC = O(n)
        public Node lowestCommonAncestor(Node p, Node q) {
            Set<Node> set = new HashSet<>();
            while (p != null) {
                set.add(p);
                p = p.parent;
            }
            while (q != null) {
                if (set.contains(q)) {
                    return q;
                }
                q = q.parent;
            }
            return null;
        }
    }

    class Solution2 {
        // Method 2: two pointers
        // TC = O(n), SC = O(1)
        public Node lowestCommonAncestor(Node p, Node q) {
            Node cur1 = p, cur2 = q;
            while (cur1 != cur2) {
                cur1 = cur1 == null ? q : cur1.parent;
                cur2 = cur2 == null ? p : cur2.parent;
            }
            return cur1;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
