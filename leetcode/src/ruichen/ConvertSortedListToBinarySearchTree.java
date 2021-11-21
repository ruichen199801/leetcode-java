package ruichen;

public class ConvertSortedListToBinarySearchTree {

    // #109 https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
    // Tree, Binary Search Tree, Divide and Conquer
    // TC = O(n), SC = O(h)

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            return helper(head, null);
        }

        private TreeNode helper(ListNode start, ListNode end) {
            if (start == null || start == end) {
                return null;
            }
            ListNode mid = findMid(start, end);
            TreeNode root = new TreeNode(mid.val);
            root.left = helper(start, mid);
            root.right = helper(mid.next, end);
            return root;
        }

        private ListNode findMid(ListNode start, ListNode end) {
            ListNode fast = start, slow = start;
            while (fast.next != end && fast.next.next != end) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
