package ruichen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindIfPathExistsInGraph {
    class Solution1 {
        // Method 1: BFS
        // TC = O(V + E), SC = O(V + E) (consider hash map in SC)
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            // Store paths in map for O(1) lookup
            Map<Integer, List<Integer>> paths = new HashMap<>();
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                // Bidirectional: add both u->v and v->u for (u, v)
                if (!paths.containsKey(u)) paths.put(u, new ArrayList<>());
                if (!paths.containsKey(v)) paths.put(v, new ArrayList<>());
                paths.get(u).add(v);
                paths.get(v).add(u);
            }
            // Keep track of visited nodes
            boolean[] visited = new boolean[n];
            visited[source] = true;
            // Initialize BFS queue
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(source);
            // BFS
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (cur == destination) {
                    return true;
                }
                for (int nei : paths.get(cur)) {
                    if (!visited[nei]) {
                        queue.offer(nei);
                    }
                    visited[nei] = true;
                }
            }
            return false;
        }
    }

    class Solution2 {
        // Method 2: DFS
        // TC = O(V + E), SC = O(V + E) (consider hash map in SC)
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            // Build adjacency list
            Map<Integer, List<Integer>> paths = new HashMap<>();
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                if (!paths.containsKey(u)) paths.put(u, new ArrayList<>());
                if (!paths.containsKey(v)) paths.put(v, new ArrayList<>());
                paths.get(u).add(v);
                paths.get(v).add(u);
            }
            // Track visited nodes
            boolean[] visited = new boolean[n];
            return dfs(paths, visited, source, destination);
        }

        private boolean dfs(Map<Integer, List<Integer>> paths, boolean[] visited, int cur, int destination) {
            // Return result
            if (cur == destination) {
                return true;
            }
            // Skip visited nodes
            if (visited[cur]) {
                return false;
            }
            visited[cur] = true;
            for (int nei : paths.get(cur)) {
                if (dfs(paths, visited, nei, destination)) {
                    return true;
                }
            }
            return false;
        }
    }

    class Solution3 {
        // Method 3: Disjoint Set Union
        // TC: O(E * α(V)) (E times union find operations, α(V) is inverse Ackermann function)
        // One operation: worse case O(n) -> O(log n) (path compression) -> O(α(n)) (union by rank)
        // SC: O(V) (2V for root array and rank array)
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            UnionFind uf = new UnionFind(n);
            for (int[] edge : edges) {
                uf.union(edge[0], edge[1]);
            }
            return uf.find(source) == uf.find(destination);
        }
    }

    class UnionFind {
        private int[] root;
        private int[] rank;

        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            // First assume there is no edge and all nodes are isolated
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        // Find root
        public int find(int u) {
            // Path compression to reduce TC
            if (root[u] != u) {
                root[u] = find(root[u]);
            }
            // The node is already the root
            return root[u];
        }

        // Merges two nodes into the same group if they do not have the same root value
        public void union(int u, int v) {
            int rootU = find(u), rootV = find(v);
            if (rootU != rootV) {
                // Let u < v
                if (this.rank[rootU] > this.rank[rootV]) {
                    int temp = rootU;
                    rootU = rootV;
                    rootV = temp;
                }
                // Let larger group (taller tree) be the new root after merge
                this.root[rootU] = rootV;
                this.rank[rootV] += this.rank[rootU];
            }
        }
    }
}
