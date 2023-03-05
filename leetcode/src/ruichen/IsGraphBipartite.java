package ruichen;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class IsGraphBipartite {
    // TC = O(n + e), n for node and e for edge; SC = O(n)
    class Solution {
        public boolean isBipartite(int[][] graph) {
            if (graph == null || graph.length == 0) {
                return false;
            }
            // use hashmap to record visited nodes: <node, color>
            // it's possible for a node to be re-generated, therefore de-dup is necessary
            Map<Integer, Integer> visited = new HashMap<>();

            // every node has possibly a bunch of neighbors to generate, so wrap the bfs
            // function with a for-loop to traverse every node and do the same process
            for (int i = 0; i < graph.length; i++) {
                if (!bfs(graph, i, visited)) {
                    return false;
                }
            }
            return true;
        }

        private boolean bfs(int[][] graph, int node, Map<Integer, Integer> visited) {
            Queue<Integer> queue = new ArrayDeque<>();
            if (!visited.containsKey(node)) {
                queue.offer(node); // index of the node
                visited.put(node, 0);
            }
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int curColor = visited.get(cur);
                int neiColor = curColor == 0 ? 1 : 0;
                for (int neighbor : graph[cur]) {
                    if (!visited.containsKey(neighbor)) {
                        queue.offer(neighbor);
                        visited.put(neighbor, neiColor);
                    } else if (visited.get(neighbor) != neiColor) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
