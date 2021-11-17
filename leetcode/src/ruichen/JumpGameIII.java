package ruichen;

import java.util.ArrayDeque;
import java.util.Queue;

public class JumpGameIII {

    // #1306 https://leetcode.com/problems/jump-game-iii/
    // Array, Depth-first Search, Breadth-first Search

    class Solution1 {
        public boolean canReach(int[] arr, int start) {
            // mark as visited: make the number negative (all entries are positive numbers)
            // BFS: enqueue index of the array
            // TC = O(n), SC = O(n) (queue on heap)

            // arr = [4,2,3,0,3,1,2], start = 5
            // 5 -> 4 6
            // 4 -> 1
            // 1 -> 3
            // 3 -> arr[3] == 0, true
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                // check if visited
                if (arr[node] < 0) {
                    continue;
                }
                // check if equals the answer
                if (arr[node] == 0) {
                    return true;
                }
                // offer neighbors
                if (node + arr[node] < arr.length) {
                    queue.offer(node + arr[node]);
                }
                if (node - arr[node] >= 0) {
                    queue.offer(node - arr[node]);
                }
                // mark current node as visited
                arr[node] = -arr[node];
            }
            return false;
        }
    }

    class Solution2 {
        public boolean canReach(int[] arr, int start) {
            // DFS: TC = O(n), SC = O(n) (recursion stack)
            if (start < 0 || start >= arr.length || arr[start] < 0) {
                return false;
            }
            if (arr[start] == 0) {
                return true;
            }
            arr[start] = -arr[start];
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }
    }
}
