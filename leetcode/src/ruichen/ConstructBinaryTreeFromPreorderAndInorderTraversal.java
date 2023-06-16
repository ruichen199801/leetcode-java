package ruichen;

import ruichen.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    // preorder: n1, left, right
    // inorder: ...(lsub) n1 ...(rsub)

    // step 1: find root node using preorder array (scan from left to right).
    // step 2: split into 2 halves recursively using inorder array.

    // TC = O(n), SC = O(n) (recursion + hash map)
    class Solution {
        private int preIndex = 0;
        private Map<Integer, Integer> inIndexMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // look up inorder index in O(1)
            for (int i = 0; i < inorder.length; i++) {
                inIndexMap.put(inorder[i], i);
            }

            return dfs(preorder, 0, inorder.length - 1);
        }

        private TreeNode dfs(int[] preorder, int inLeft, int inRight) {
            if (inLeft > inRight) {
                return null;
            }

            int rootValue = preorder[preIndex++];
            int inIndex = inIndexMap.get(rootValue);

            TreeNode root = new TreeNode(rootValue);
            root.left = dfs(preorder, inLeft, inIndex - 1); // dereference to construct tree
            root.right = dfs(preorder, inIndex + 1, inRight);

            return root;
        }
    }
}
