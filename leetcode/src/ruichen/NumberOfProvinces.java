package ruichen;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfProvinces {
    class Solution1 {
        // DFS: TC = O(n^2), SC = O(n) for n * n matrix
        // adjacency matrix: dfs + a set to track visited nodes
        public int findCircleNum(int[][] isConnected) {
            boolean[] visited = new boolean[isConnected.length];
            int count = 0;
            for (int i = 0; i < isConnected.length; i++) {
                if (!visited[i]) {
                    dfs(isConnected, visited, i);
                    count++;
                }
            }
            return count;
        }

        private void dfs(int[][] isConnected, boolean[] visited, int i) {
            for (int j = 0; j < isConnected.length; j++) {
                if (!visited[j] && isConnected[i][j] == 1) {
                    visited[j] = true;
                    dfs(isConnected, visited, j);
                }
            }
        }
    }

    class Solution2 {
        // BFS: TC = O(n^2), SC = O(n) for n * n matrix
        public int findCircleNum(int[][] isConnected) {
            boolean[] visited = new boolean[isConnected.length];
            int count = 0;
            for (int i = 0; i < isConnected.length; i++) {
                if (!visited[i]) {
                    bfs(isConnected, visited, i);
                    count++;
                }
            }
            return count;
        }

        private void bfs(int[][] isConnected, boolean[] visited, int i) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                visited[node] = true;
                for (int j = 0; j < isConnected.length; j++) {
                    if (!visited[j] && isConnected[node][j] == 1) {
                        queue.offer(j);
                    }
                }
            }
        }
    }
}
