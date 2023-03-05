package ruichen;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    class Solution1 {
        // Iterative: TC = O(n), SC = O(n)
        public Node copyRandomList(Node head) {
            if (head == null) {
                return head;
            }
            // original node -> copied node
            Map<Node, Node> map = new HashMap<>();
            Node newHead = new Node(head.val);
            map.put(head, newHead);
            Node cur = newHead;
            while (head != null) {
                if (head.next != null) {
                    if (!map.containsKey(head.next)) {
                        map.put(head.next, new Node(head.next.val));
                    }
                    cur.next = map.get(head.next);
                }
                if (head.random != null) {
                    if (!map.containsKey(head.random)) {
                        map.put(head.random, new Node(head.random.val));
                    }
                    cur.random = map.get(head.random);
                }
                head = head.next;
                cur = cur.next;
            }
            return newHead;
        }
    }

    class Solution2 {
        // Recursive: : TC = O(n), SC = O(n)
        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>();
            return copyRandomList(head, map);
        }

        private Node copyRandomList(Node head, Map<Node, Node> map) {
            if (head == null) {
                return null;
            }
            if (map.containsKey(head)) {
                return map.get(head);
            }
            Node newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.next = copyRandomList(head.next, map);
            newHead.random = copyRandomList(head.random, map);
            return newHead;
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
