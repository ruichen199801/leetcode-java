package ruichen;

public class LinkedListCycle {
	
	public class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}

	public class Solution {

		// #141 https://leetcode-cn.com/problems/linked-list-cycle/
		// Linked List
		// TC = O(n), SC = O(1)

		public boolean hasCycle(ListNode head) {
			if (head == null || head.next == null) {
				return false;
			}
			ListNode slow = head, fast = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				if (slow == fast) {
					return true;
				}
			}
			return false;
		}
	}

}
