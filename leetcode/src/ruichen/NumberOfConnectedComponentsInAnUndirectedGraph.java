package ruichen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    // #323 https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
    // Graph, Depth-first Search, Breadth-first Search, Union Find
    // Same as #1971

    class Solution1 {
        // Method 1: BFS
        // TC = O(V + E), SC = O(V + E) (consider hash map in SC)
        public int countComponents(int n, int[][] edges) {
            Map<Integer, List<Integer>> paths = new HashMap<>();
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                if (!paths.containsKey(u)) paths.put(u, new ArrayList<>());
                if (!paths.containsKey(v)) paths.put(v, new ArrayList<>());
                paths.get(u).add(v);
                paths.get(v).add(u);
            }
            boolean[] visited = new boolean[n];
            int numOfComponents = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    numOfComponents++;
                    bfs(paths, visited, i);
                }
            }
            return numOfComponents;
        }

        private void bfs(Map<Integer, List<Integer>> paths, boolean[] visited, int i) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (paths.get(cur) == null) {
                    break;
                }
                for (int nei : paths.get(cur)) {
                    if (!visited[nei]) {
                        queue.offer(nei);
                        visited[nei] = true;
                    }
                }
            }
        }
    }

    class Solution2 {
        // Method 2: DFS
        // TC = O(V + E), SC = O(V + E) (consider hash map in SC)
        public int countComponents(int n, int[][] edges) {
            Map<Integer, List<Integer>> paths = new HashMap<>();
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                if (!paths.containsKey(u)) paths.put(u, new ArrayList<>());
                if (!paths.containsKey(v)) paths.put(v, new ArrayList<>());
                paths.get(u).add(v);
                paths.get(v).add(u);
            }
            boolean[] visited = new boolean[n];
            int numOfComponents = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    numOfComponents++;
                    dfs(paths, visited, i);
                }
            }
            return numOfComponents;
        }

        private void dfs(Map<Integer, List<Integer>> paths, boolean[] visited, int cur) {
            visited[cur] = true;
            if (paths.get(cur) == null) {
                return;
            }
            for (int nei : paths.get(cur)) {
                if (!visited[nei]) {
                    dfs(paths, visited, nei);
                }
            }
        }
    }

    class Solution3 {
        // Method 3: Union Find (with path compression, without union by rank)
        // TC = O(V + E log V)
        //    = O(V * E) without path compression
        //    = O(V + E * amortized log V) with path compression + union by rank, close to constant * E
        // SC = O(V)
        public int countComponents(int n, int[][] edges) {
            int[] root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            for (int[] edge : edges) {
                union(edge[0], edge[1], root);
            }
            Set<Integer> uniqueRoot = new HashSet<>();
            for (int i = 0; i < n; i++) {
                uniqueRoot.add(find(root[i], root));
            }
            return uniqueRoot.size();
        }

        private void union(int u, int v, int[] root) {
            int rootU = find(u, root), rootV = find(v, root);
            root[rootU] = rootV;
        }

        private int find(int u, int[] root) {
            if (root[u] != u) {
                root[u] = find(root[u], root);
            }
            return root[u];
        }
    }
}
