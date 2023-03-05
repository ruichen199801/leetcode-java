package ruichen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {
    // TC = O(E + V), SC = O(E + V) (E: number of dependencies, V: number of courses)
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] res = new int[numCourses];
            int[] indegree = new int[numCourses];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            // 1. Build graph and indegree list
            for (int[] edge : prerequisites) {
                int start = edge[1], end = edge[0];
                if (!graph.containsKey(start)) {
                    graph.put(start, new ArrayList<>());
                }
                graph.get(start).add(end);
                indegree[end]++; // end<-start
            }
            // 2. Find entry point (indegree = 0)
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
            // 3. BFS + Topological Sort
            int count = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                res[count++] = cur;
                if (graph.containsKey(cur)) {
                    for (int nei : graph.get(cur)) {
                        indegree[nei]--; // remove dependency
                        if (indegree[nei] == 0) {
                            queue.offer(nei);
                        }
                    }
                }
            }
            return count == numCourses ? res : new int[0];
        }
    }
}
