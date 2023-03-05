package ruichen;

import ruichen.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumIV {
    class Solution1 {
        // inorder traverse a BST -> ascending ordered list
        // first convert the tree into a sorted list using inorder traversal, then use two pointers
        // TC = O(n) for in-order traversal + O(n) for linear scan = O(n)
        // SC = O(n) for worst case tree traversal + O(n) for array list = O(n)
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> numList = new ArrayList<>();
            inorder(root, numList);
            int i = 0, j = numList.size() - 1;
            while (i < j) {
                if (numList.get(i) + numList.get(j) == k) {
                    return true;
                } else if (numList.get(i) + numList.get(j) < k) {
                    i++;
                } else {
                    j--;
                }
            }
            return false;
        }

        private void inorder(TreeNode root, List<Integer> numList) {
            if (root == null) {
                return;
            }
            inorder(root.left, numList);
            numList.add(root.val);
            inorder(root.right, numList);
        }
    }

    class Solution2 {
        // build a set to record node values, recursively traverse the tree and compare on the fly
        // TC = O(n) (tree traversal), SC = O(n) (set size)
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> set = new HashSet<>();
            return helper(root, k, set);
        }

        private boolean helper(TreeNode root, int k, Set<Integer> set) {
            if (root == null) {
                return false;
            }
            if (set.contains(k - root.val)) {
                return true;
            }
            set.add(root.val);
            return helper(root.left, k, set) || helper(root.right, k, set);
        }
    }
}
