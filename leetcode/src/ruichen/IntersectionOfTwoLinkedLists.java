package ruichen;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
	
	// #160 https://leetcode.com/problems/intersection-of-two-linked-lists/
	// Linked List
	
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public class Solution1 {

	    // Hash Set: TC = O(m + n), SC = O(m) or O(n)

	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        Set<ListNode> set = new HashSet<>();
	        ListNode curA = headA;
	        while (curA != null) {
	            set.add(curA);
	            curA = curA.next;
	        }
	        ListNode curB = headB;
	        while (curB != null) {
	            if (set.contains(curB)) {
	                return curB;
	            } else {
	                curB = curB.next;
	            }
	        }
	        return null;
	    }
	}
	
	public class Solution2 {

	    // similar to the idea of checking cycle using two pointers
	    // if A and B do not intersect, curA == curB == null, so won't infinite loop
	    // TC = O(m + n), SC = O(1)

	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        ListNode curA = headA, curB = headB;
	        while (curA != curB) {
	            curA = curA == null ? headB : curA.next;
	            curB = curB == null ? headA : curB.next;
	        }
	        return curA;     
	    }
	}

}
