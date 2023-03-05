package ruichen;

import ruichen.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    class Solution1 {
        // Merge sort: pair up k lists and merge each pair, repeat this process until we get the final list

        // TC = O(kn log k) or O(N log k)
        // k: # of lists, n: # of nodes in each list, N: # of nodes in final list
        // k log k for sum of time complexity for all nodes on the recursion tree, n for O(n) merge 2 sorted lists

        // SC = O(log k)
        // we can do this iteratively then the space complexity is O(1).
        // It's not hard to apply in-place method b/c we connect selected nodes instead of creating new nodes to fill the new linked list.
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            return partition(lists, 0, lists.length - 1);
        }

        private ListNode partition(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            int mid = left + (right - left) / 2;
            ListNode leftList = partition(lists, left, mid);
            ListNode rightList = partition(lists, mid + 1, right);
            return merge(leftList, rightList);
        }

        private ListNode merge(ListNode leftList, ListNode rightList) {
            ListNode result = new ListNode(0);
            ListNode curr = result;
            while (leftList != null && rightList != null) {
                if (leftList.val < rightList.val) {
                    curr.next = leftList;
                    leftList = leftList.next;
                } else {
                    curr.next = rightList;
                    rightList = rightList.next;
                }
                curr = curr.next;
            }
            if (leftList == null) {
                curr.next = rightList;
            }
            if (rightList == null) {
                curr.next = leftList;
            }
            return result.next;
        }
    }

    class Solution2 {
        // minHeap: compare and merge all lists together

        // TC = O(N log k), offer/poll O(log k) for minHeap, we perform N times of such operations
        // SC = O(k), size of the minHeap
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
            ListNode result = new ListNode(0);
            ListNode curr = result;
            for (ListNode list : lists) {
                if (list != null) {
                    minHeap.offer(list);
                }
            }
            while (!minHeap.isEmpty()) {
                curr.next = minHeap.poll();
                if (curr.next.next != null) {
                    minHeap.offer(curr.next.next);
                }
                curr = curr.next;
            }
            return result.next;
        }
    }
}
