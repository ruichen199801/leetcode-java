package ruichen;

public class AddTwoNumbersII {

    // #445 https://leetcode.com/problems/add-two-numbers-ii/
    // Math, Linked list
    // TC = O(N1 + N2), SC = O(1) without considering output, O(max(N1, N2)) -> "new" to store output list

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = reverse(l1);
            l2 = reverse(l2);
            ListNode head = null;
            int carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                int sum = carry;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                carry = sum / 10;
                // update result: insert at head (reverse)
                ListNode curr = new ListNode(sum % 10); // takes space
                curr.next = head;
                head = curr;
            }
            return head;
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }
}
