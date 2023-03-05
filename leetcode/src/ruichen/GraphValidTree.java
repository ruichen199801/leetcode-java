package ruichen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphValidTree {
    /*
    General check if E = V - 1 (can do without it)

    Method 1: Run BFS/DFS ONCE from a random node to check if cyclic
              (at least in the current connected component),
              then iterate the visited boolean array to check if connected.
              Maintain parent array to avoid counting parent as cycle.

              TC = O(V + E), SC = O(V + E)

    Method 2: Reuse codes in #323: Run BFS/DFS IN A LOOP to count number of
              connected components, and use count == 1 to check if connected.
              If we already checked edge count E = V - 1 and checked if connected,
              there is no need to check if cyclic.

              TC = O(V + E), SC = O(V + E)

    Method 3: Union find (with path compression)

              TC = O(V + E log V), SC = O(V)
    */

    class Solution1 {
        // Method 1 - BFS
        public boolean validTree(int n, int[][] edges) {
            // corner case: if there are more than n-1 edges, then there must be at least one cycle
            if (edges.length != n - 1) {
                return false;
            }

            // initialize the adjacency list and visited array
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            for (int i = 0; i < n; i++) {
                adjList.put(i, new ArrayList<>());
            }
            for (int[] edge : edges) {
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }
            boolean[] visited = new boolean[n];

            // use BFS to check if there is a cycle
            Queue<Integer> queue = new ArrayDeque<>();
            int[] parent = new int[n];
            Arrays.fill(parent, -1);
            queue.offer(0);
            visited[0] = true;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int neighbor : adjList.get(cur)) {
                    if (visited[neighbor]) {
                        // check if the neighbor is not the parent
                        if (neighbor != parent[cur]) {
                            return false;
                        }
                    } else {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                        parent[neighbor] = cur;
                    }
                }
            }

            // check if all nodes are connected
            for (boolean v : visited) {
                if (!v) {
                    return false;
                }
            }
            return true;
        }
    }


    class Solution2 {
        // Method 1 - DFS
        public boolean validTree(int n, int[][] edges) {
            // corner case: if there are more than n-1 edges, then there must be at least one cycle
            if (edges.length != n - 1) {
                return false;
            }

            // initialize the adjacency list and visited array
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            for (int i = 0; i < n; i++) {
                adjList.put(i, new ArrayList<>());
            }
            for (int[] edge : edges) {
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }
            boolean[] visited = new boolean[n];

            // use DFS to check if there is a cycle
            int[] parent = new int[n];
            Arrays.fill(parent, -1);
            if (hasCycle(adjList, visited, 0, parent)) {
                return false;
            }

            // check if all nodes are connected
            for (boolean v : visited) {
                if (!v) {
                    return false;
                }
            }
            return true;
        }

        private boolean hasCycle(Map<Integer, List<Integer>> adjList, boolean[] visited, int cur, int[] parent) {
            visited[cur] = true;
            for (int neighbor : adjList.get(cur)) {
                if (!visited[neighbor]) {
                    parent[neighbor] = cur;
                    if (hasCycle(adjList, visited, neighbor, parent)) {
                        return true;
                    }
                } else {
                    // check if the neighbor is not the parent
                    if (neighbor != parent[cur]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }


    class Solution3 {
        // Method 3: Union Find
        public boolean validTree(int n, int[][] edges) {
            if (edges == null || edges.length != n - 1) {
                return false;
            }
            int[] root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            for (int[] edge : edges) {
                if (!union(edge[0], edge[1], root)) {
                    return false;
                }
            }
            return true;
        }

        private boolean union(int u, int v, int[] root) {
            int rootU = find(u, root), rootV = find(v, root);

            // if the vertices belong to the same set, then there is a cycle in the graph
            // proof: we already know u->v, if they have same root, then
            // r->u, r->v, therefore r, u, v form a cycle
            if (rootU == rootV) {
                return false;
            }
            root[rootU] = rootV;
            return true;
        }

        private int find(int u, int[] root) {
            if (root[u] != u) {
                root[u] = find(root[u], root);
            }
            return root[u];
        }
    }
}
