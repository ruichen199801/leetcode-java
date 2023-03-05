package ruichen;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    class Solution1 {
        // BFS: TC = O(V + E), SC = O(V)
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if (rooms == null || rooms.size() == 0) {
                return false;
            }

            int n = rooms.size();
            Queue<List<Integer>> queue = new ArrayDeque<>();
            queue.offer(rooms.get(0));
            boolean[] visited = new boolean[n];
            visited[0] = true;

            while (!queue.isEmpty()) {
                List<Integer> cur = queue.poll();
                if (cur.size() == 0) {
                    continue;
                }
                for (int nei : cur) {
                    if (!visited[nei]) {
                        queue.offer(rooms.get(nei));
                        visited[nei] = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution2 {
        // DFS: TC = O(V + E), SC = O(V)
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if (rooms == null || rooms.size() == 0) {
                return false;
            }

            int n = rooms.size();
            boolean[] visited = new boolean[n];
            // run dfs ONLY ONCE!
            // If we run dfs in a loop, the result is always true, as we modify the boolean array
            // in multiple runs instead of resetting it when we start a new run
            dfs(rooms, visited, 0);

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    return false;
                }
            }
            return true;
        }

        private void dfs(List<List<Integer>> rooms, boolean[] visited, int cur) {
            visited[cur] = true;
            if (rooms.get(cur).size() == 0) {
                return;
            }
            for (int nei : rooms.get(cur)) {
                if (!visited[nei]) {
                    dfs(rooms, visited, nei);
                }
            }
        }
    }
}
