package ruichen;

import java.util.*;

public class AllPathsFromSourceToTarget {

    // #797 https://leetcode.com/problems/all-paths-from-source-to-target/
    // Breadth-first Search, Graph
    // TC = O(n^2 * 2^n): n: for (int neighbor : neighbors)
    //                    n: List<Integer> newPath = new ArrayList<>(path);
    //                   2^n: for every node, either add it in the path or not
    // SC = O(2^n): worst case enqueue all possible paths

    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> result = new ArrayList<>();
            // store paths starting from each node in the queue and update them on the fly
            // [[0]] -> [[0 -> 1], [0 -> 2]] -> ...
            Queue<List<Integer>> queue = new ArrayDeque<>();
            queue.offer(Arrays.asList(0));
            while (!queue.isEmpty()) {
                List<Integer> path = queue.poll();
                int goalNode = graph.length - 1;
                int lastNode = path.get(path.size() - 1);
                if (goalNode == lastNode) {
                    result.add(new ArrayList<>(path));
                } else {
                    int[] neighbors = graph[lastNode];
                    for (int neighbor : neighbors) {
                        List<Integer> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        queue.offer(newPath);
                    }
                }
            }
            return result;
        }
    }
}
