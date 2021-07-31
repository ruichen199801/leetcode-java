package ruichen;

public class RemoveDuplicatesFromSortedListII {
	
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	class Solution {

	    // #82 https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
	    // Linked List
	    // TC = O(n), SC = O(1)

	    public ListNode deleteDuplicates(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }
	        ListNode dummy = new ListNode(0); 
	        dummy.next = head;
	        ListNode cur = dummy;
	        while (cur.next != null && cur.next.next != null) {
	            if (cur.next.val == cur.next.next.val) {
	                ListNode temp = cur.next;
	                while (temp.next != null && temp.val == temp.next.val) {
	                    temp = temp.next;
	                }
	                cur.next = temp.next; // skip all duplicate nodes
	            } else {
	                cur = cur.next; // change nothing
	            }
	        }
	        return dummy.next;
	        //   1->1->1->2->3
	        //         t
	        // c  0->1->1->1->2->3
	         
	        //   1->1->1->2->3
	        //         t    
	        // c  0->2->3
	    }
	}

}
