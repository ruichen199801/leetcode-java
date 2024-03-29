package ruichen;

import ruichen.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
    // TC = O(n), SC = O(1)
    class Solution {
        public int numComponents(ListNode head, int[] nums) {
            // all values are unique: use set for O(1) lookup
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }
            int numComponents = 0;
            ListNode cur = head;
            while (cur != null) {
                //  0 -> 1 -> 2 -> 3   [0, 1, 3]
                // cur
                if (numSet.contains(cur.val)) {
                    numComponents++;
                    while (cur != null && numSet.contains(cur.val)) {
                        cur = cur.next;
                    }
                } else {
                    cur = cur.next;
                }
            }
            return numComponents;
        }
    }
}
