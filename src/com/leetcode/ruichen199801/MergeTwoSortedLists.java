package com.leetcode.ruichen199801;

public class MergeTwoSortedLists {
	
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}
	
	class Solution {

	    // #21 https://leetcode-cn.com/problems/merge-two-sorted-lists
	    // Linked List
	    // TC = O(m + n), SC = O(1)

	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if (l1 == null) {
	            return l2;
	        }
	        if (l2 == null) {
	            return l1;
	        }
	        ListNode dummy = new ListNode(0);
	        ListNode cur1 = l1, cur2 = l2, cur = dummy;
	        while (cur1 != null && cur2 != null) {
	            if (cur1.val < cur2.val) {
	                cur.next = cur1;
	                cur1 = cur1.next;
	            } else {
	                cur.next = cur2;
	                cur2 = cur2.next;
	            }
	            cur = cur.next;
	        } 
	        if (cur1 == null) {
	            cur.next = cur2;
	        }
	        if (cur2 == null) {
	            cur.next = cur1;
	        }
	        return dummy.next;
	    }
	}

}
