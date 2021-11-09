package ruichen;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    // #95 https://leetcode.com/problems/unique-binary-search-trees-ii/
    // Tree, Depth-first Search, Dynamic Programming

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new ArrayList<>();
            }
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int start, int end) {
            // base case
            List<TreeNode> trees = new ArrayList<>();
            if (start > end) {
                trees.add(null);
                return trees;
            }
            // construct left subtree and right subtree list
            for (int i = start; i <= end; i++) { // i as root
                List<TreeNode> leftTrees = generateTrees(start, i - 1);
                List<TreeNode> rightTrees = generateTrees(i + 1, end);
                // then connect current tree node to them
                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode root = new TreeNode(i); // current tree node
                        root.left = left;
                        root.right = right;
                        trees.add(root);
                    }
                }
            }
            return trees;
        }
    }
}
