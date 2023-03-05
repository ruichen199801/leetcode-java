package ruichen;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // Doubly Linked List + Hash Map
    // DLL: pseudo head + pseudo tail to mark the boundary
    // head <-> xxx <-> tail

    // TC = O(1) (put, get), SC = O(capacity)
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    private int capacity;
    private int size;
    private Node head, tail;
    private Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node); // to mark as most recently accessed
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node); // to mark as most recently accessed
        } else {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);
            size++;
            if (size > capacity) {
                Node tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        }
    }

    private void addNode(Node node) {
        // add new node after head
        // h <-> new <-> n1
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        // n1 <-> rmv <-> n2
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node popTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}
