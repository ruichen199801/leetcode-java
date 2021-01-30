package com.leetcode.ruichen199801;

public class ReverseLinkedList {
	
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}
	
	class Solution1 {
		 
	    // #206 https://leetcode-cn.com/problems/reverse-linked-list/
	    // Linked List
	    // Iterative: TC = O(n), SC = O(1)
	    
	    public ListNode reverseList(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }
	        ListNode prev = null, curr = head;
	        while (curr != null) {
	            ListNode next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	        }
	        return prev;
	    }
	}
	
	class Solution2 {

	    // recursive: TC = O(n), SC = O(n)
	    
	    public ListNode reverseList(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }
	        ListNode newHead = reverseList(head.next);
	        head.next.next = head;
	        head.next = null;
	        return newHead;
	    }
	}

}
