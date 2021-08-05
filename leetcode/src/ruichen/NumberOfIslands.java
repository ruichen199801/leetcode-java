package ruichen;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

    // #200 https://leetcode.com/problems/number-of-islands/
    // Breadth-first Search, Depth-first Search

    class Solution1 {

        private final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int numIslands(char[][] grid) { // char, not int!!!

            // BFS
            // TC = O(n * m) worst case: all 1s and we have to look at every element
            // SC = O(max(n, m)) queue size

            // Queue []
            // 1 < m, n <= 300
            // 2D -> 1D: [r][c] -> r * col + c
            // 1D -> 2D: index -> [index / col][index % col]

            int m = grid.length, n = grid[0].length;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        fillWithWater(grid, m, n, i, j);
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        // push connected lands into queue, and fill with water (set 1 to 0) to avoid repeated count of the same island
        private void fillWithWater(char[][] grid, int m, int n, int i, int j) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i * n + j); // initialize by pushing the first element into queue
            grid[i][j] = '0'; // whenever we push an new element into queue which represents a land, we fill it with water

            // "offer -> set to 0 -> poll -> check its neighbors" loop
            while (!queue.isEmpty()) {
                int index = queue.poll();
                int row = index / n;
                int col = index % n;
                // check its 4 neighbors
                for (int[] direction : DIRECTIONS) {
                    int x = row + direction[0], y = col + direction[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                        queue.offer(x * n + y);
                        grid[x][y] = '0';
                    }
                }
            }
        }
    }

    class Solution2 {
        public int numIslands(char[][] grid) {

            // DFS
            // TC = O(n * m), SC = O(n * m)

            int m = grid.length, n = grid[0].length;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        fillWithWater(grid, i, j);
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        private void fillWithWater(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            fillWithWater(grid, i - 1, j);
            fillWithWater(grid, i + 1, j);
            fillWithWater(grid, i, j - 1);
            fillWithWater(grid, i, j + 1);
        }
    }
}
