package ruichen;

public class PalindromeLinkedList {
	
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}
	
	class Solution {

	    // #234 https://leetcode.com/problems/palindrome-linked-list/
	    // Linked List
	    // TC = O(n), SC = O(1)
	    
	    public boolean isPalindrome(ListNode head) {
	        if (head == null || head.next == null) {
	            return true;
	        }
	        // partition into two halves
	        ListNode mid = middleNode(head);
	        // reverse right part
	        ListNode right = reverse(mid.next);
	        // traverse and compare left part and right part
	        while (right != null) {
	            if (head.val != right.val) {
	                return false;
	            }
	            head = head.next;
	            right = right.next;
	        }
	        return true;
	    }

	    private ListNode middleNode(ListNode head) {
	        ListNode slow = head, fast = head;
	        while (fast.next != null && fast.next.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }

	    private ListNode reverse(ListNode head) {
	        ListNode pre = null;
	        while (head != null) {
	            ListNode next = head.next;
	            head.next = pre;
	            pre = head;
	            head = next;
	        }
	        return pre;
	    }
	}

}
