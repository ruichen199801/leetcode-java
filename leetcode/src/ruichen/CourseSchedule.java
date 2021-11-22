package ruichen;

import java.util.*;

public class CourseSchedule {

    // #207 https://leetcode.com/problems/course-schedule/
    // Graph, Breadth-first Search, Topological Sort
    // TC = O(E + V), SC = O(E + V) (E: number of dependencies, V: number of courses)

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> graph = new HashMap<>(); // <start, [end]>
            int[] indegree = new int[numCourses];
            // 1. Build graph and indegree
            for (int[] edge : prerequisites) {
                int end = edge[0], start = edge[1];
                if (!graph.containsKey(start)) {
                    graph.put(start, new ArrayList<>());
                }
                graph.get(start).add(end);
                indegree[end]++; // end <- start, end's indegree increases
            }
            // 2. Find entry point of the directed graph (the point where indegree = 0): initialize queue
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
            // 3. BFS + Topological sort
            int count = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                count++;
                if (graph.containsKey(cur)) {
                    for (int nei : graph.get(cur)) {
                        indegree[nei]--; // remove edge/dependency
                        if (indegree[nei] == 0) { // find in neighbors next point whose indegree == 0
                            queue.offer(nei);
                        }
                    }
                }
            }
            return count == numCourses; // have cycle: not equal
        }
    }
}
