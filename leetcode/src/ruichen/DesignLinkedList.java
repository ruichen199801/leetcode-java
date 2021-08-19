package ruichen;

public class DesignLinkedList {

    // #707 https://leetcode.com/problems/design-linked-list/
    // Design, Linked List

    class MyLinkedList1 {

        // Singly Linked List
        // addAtHead: O(1)
        // get, deleteAtIndex: O(k), k = index
        // addAtTail: O(n), n = # of nodes

        public class ListNode {
            int val;
            ListNode next;
            ListNode(int val) {
                this.val = val;
            }
        }

        private int size; // update size as we insert or delete nodes
        private ListNode head; // a sentinel node such that linked list is never empty

        /** Initialize your data structure here. */
        public MyLinkedList1() {
            size = 0;
            head = new ListNode(0);
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = head;
            for (int i = 0; i < index + 1; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            ListNode node = new ListNode(val);
            node.next = pre.next;
            pre.next = node;
            size++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
            size--;
        }
    }

    class MyLinkedList2 {

        // Doubly Linked List
        // addAtHead, addAtTail: O(1)
        // get, deleteAtIndex: O(min(k, N − k)), k is an index of the element to get, add or delete

        private int size;
        private ListNode head;
        private ListNode tail;

        class ListNode {
            int val;
            ListNode prev;
            ListNode next;
            public ListNode(int val) {
                this.val = val;
            }
        }

        /** Initialize your data structure here. */
        public MyLinkedList2() {
            size = 0;
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.prev = head;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            // corner case
            if (index < 0 || index >= size) {
                return -1;
            }
            // search begins from the closer end (head or tail)
            // head <-> n0 <-> n1 <-> n2 <-> (n3) <-> n4 <-> tail, index = 3
            ListNode cur = null;
            if (index + 1 < size - index) { // 3+1 vs 5-3
                cur = head;
                for (int i = 0; i < index + 1; i++) {
                    cur = cur.next;
                }
            } else {
                cur = tail;
                for (int i = size; i > index; i--) {
                    cur = cur.prev;
                }
            }
            return cur.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            // pred <-> node to be inserted, not exist yet <-> succ
            // search begins from the closer end (head or tail)
            // head <-> n0 <-> n1 <-> (n2) <-> (n3) <-> n4 <-> tail, index = 3
            ListNode pred = null, succ = null;
            if (index < size - index) { // 3 vs 5-3
                pred = head;
                for (int i = 0; i < index; i++) {
                    pred = pred.next;
                }
                succ = pred.next;
            } else {
                succ = tail;
                for (int i = size; i > index; i--) {
                    succ = succ.prev;
                }
                pred = succ.prev;
            }
            ListNode node = new ListNode(val);
            node.prev = pred;
            node.next = succ;
            pred.next = node;
            succ.prev = node;
            size++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            // pred <-> node to be deleted, already exists <-> succ
            // search begins from the closer end (head or tail)
            // head <-> n0 <-> n1 <-> (n2) <-> n3 <-> (n4) <-> tail, index = 3
            ListNode pred = null, succ = null;
            if (index < size - index - 1) { // 3 vs 5-3-1
                pred = head;
                for (int i = 0; i < index; i++) {
                    pred = pred.next;
                }
                succ = pred.next.next;
            } else {
                succ = tail;
                for (int i = size - 1; i > index; i--) {
                    succ = succ.prev;
                }
                pred = succ.prev.prev;
            }
            pred.next = succ;
            succ.prev = pred;
            size--;
        }
    }
}
