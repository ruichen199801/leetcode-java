package ruichen;

import java.util.ArrayDeque;
import java.util.Queue;

public class OneZeroMatrix {
    // Do BFS on the 0s. When we expand to 0s' neighbors, update 1's distances and enqueue 1
    // TC = O(m * n), SC = O(m * n)
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int[][] dist = new int[m][n];
            Queue<int[]> queue = new ArrayDeque<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                    } else {
                        dist[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            while (!queue.isEmpty()) {
                int[] cell = queue.poll(); // we already updated dist when traversing neighbors, so no action here
                int row = cell[0], col = cell[1];
                for (int[] dir : dirs) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n) {
                        continue;
                    }
                    if (dist[newRow][newCol] == Integer.MAX_VALUE) {
                        dist[newRow][newCol] = dist[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            return dist;
        }
    }
}
