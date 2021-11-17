package ruichen;

import java.util.*;

public class JumpGameIV {

    // #1345 https://leetcode.com/problems/jump-game-iv/
    // Array, Hash Table, Breadth-first Search
    // TC = O(n), SC = O(n)

    class Solution {
        public int minJumps(int[] arr) {
            // BFS: reach end, return steps: automatically "minSteps"
            // arr = [100,-23,-23,404,100,23,23,23,3,404]
            // dict: {100: [0, 4]}, {-23: [1, 2]}, {404: [3, 9]}, {23: [5, 6, 7]}, {3: [8]}
            // visited set (offer into queue and visited set at the same time)
            // queue
            // algorithm: initialize, check answer, expand neighbors (same value -> +1 / -1), update steps

            // steps 3
            // dict: {100: []}, {-23: []}, {404: []}, {23: []}, {3: [8]}
            // visited 0 4 1 3 5 2 6 7 9
            // queue   9 6 7

            if (arr == null || arr.length <= 1) {
                return 0;
            }

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], new ArrayList<>());
                }
                map.get(arr[i]).add(i);
            }

            Queue<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            queue.offer(0);
            visited.add(0);
            int minSteps = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    if (cur == arr.length - 1) {
                        return minSteps;
                    }

                    for (int nei : map.get(arr[cur])) {
                        if (!visited.contains(nei)) {
                            queue.offer(nei);
                            visited.add(nei);
                        }
                    }
                    map.get(arr[cur]).clear();

                    if (cur + 1 < arr.length && !visited.contains(cur + 1)) {
                        queue.offer(cur + 1);
                        visited.add(cur + 1);
                    }
                    if (cur - 1 >= 0 && !visited.contains(cur - 1)) {
                        queue.offer(cur - 1);
                        visited.add(cur - 1);
                    }
                }
                minSteps++;
            }
            return -1;
        }
    }
}
