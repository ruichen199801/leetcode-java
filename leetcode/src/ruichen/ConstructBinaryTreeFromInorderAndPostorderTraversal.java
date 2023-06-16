package ruichen;

import ruichen.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    // postorder: left, right, n1
    // inorder: ...(lsub) n1 ...(rsub)

    // step 1: find root node using postorder array (scan backwards, right first, then left)
    // step 2: split into 2 halves recursively using inorder array.

    // TC = O(n), SC = O(n) (recursion + hash map)
    class Solution {
        private int postIndex;
        private Map<Integer, Integer> inIndexMap = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            postIndex = postorder.length - 1; // be careful with initialization

            for (int i = 0; i < inorder.length; i++) {
                inIndexMap.put(inorder[i], i);
            }

            return dfs(postorder, 0, inorder.length - 1);
        }

        private TreeNode dfs(int[] postorder, int inLeft, int inRight) {
            if (inLeft > inRight) {
                return null;
            }

            int rootValue = postorder[postIndex--];
            int inIndex = inIndexMap.get(rootValue);

            TreeNode root = new TreeNode(rootValue);
            root.right = dfs(postorder, inIndex + 1, inRight); // right first!
            root.left = dfs(postorder, inLeft, inIndex - 1);

            return root;
        }
    }
}
