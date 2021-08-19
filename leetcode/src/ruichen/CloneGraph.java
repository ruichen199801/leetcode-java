package ruichen;

import java.util.*;

public class CloneGraph {

    // #133 https://leetcode.com/problems/clone-graph/
    // Graph, Depth-first Search, Breadth-first Search

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution1 {
        public Node cloneGraph(Node node) {

            // DFS
            // Time: O(n + m), n = # of nodes/vertices, m = # of edges
            // Space: O(n) on heap (hash map) + O(h) on stack (h = height of the graph), O(n) overall

            // original       clone
            // A <-> B        A'<-> B'
            // |     |   ->   |     |
            // D <-> C        D'<-> C'

            // de-dup to avoid getting stuck in circle
            // key: original node, value: cloned node
            // A: A', B: B', C: C', D: D'

            if (node == null) {
                return null;
            }
            Map<Node, Node> visited = new HashMap<>();
            return cloneGraph(node, visited);
        }

        private Node cloneGraph(Node node, Map<Node, Node> visited) {
            // if we already cloned a copy of the node, simply return it
            if (visited.containsKey(node)) {
                return visited.get(node);
            }
            // clone from original node to the cloned node
            Node cloneNode = new Node(node.val, new ArrayList<>());
            visited.put(node, cloneNode);
            // clone from neighbor to neighbor
            for (Node neighbor : node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor, visited));
            }
            return cloneNode;
        }
    }

    class Solution2 {
        public Node cloneGraph(Node node) {

            // BFS (iterative), not recommended (highly error prone!)
            // original: node, cur, nei
            // cloned: cloneNode, visited.get(cur), cloneNei
            // TC, SC same as DFS, as we change nothing butthe sequence of traversal

            if (node == null) {
                return null;
            }
            Map<Node, Node> visited = new HashMap<>();
            Queue<Node> queue = new ArrayDeque<>();
            Node cloneNode = new Node(node.val, new ArrayList<>());
            queue.offer(node); // enqueue ORIGINAL nodes
            visited.put(node, cloneNode);
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                // loop through neighbors of ORIGINAL nodes
                for (Node nei : cur.neighbors) {
                    // make changes on the CLONED nodes
                    if (!visited.containsKey(nei)) {
                        Node cloneNei = new Node(nei.val, new ArrayList<>());
                        queue.offer(nei); // enqueue ORIGINAL nodes
                        visited.put(nei, cloneNei);
                    }
                    visited.get(cur).neighbors.add(visited.get(nei));
                }
            }
            return cloneNode;
        }
    }
}
