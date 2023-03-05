package ruichen;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxAreaOfIsland {
    class Solution1 {
        // DFS: TC = O(n * m), SC = O(n * m)
        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int m = grid.length, n = grid[0].length;
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        max = Math.max(max, getArea(grid, m, n, i, j));
                    }
                }
            }
            return max;
        }

        private int getArea(int[][] grid, int m, int n, int i, int j) {
            if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
                return 0;
            }
            grid[i][j] = 0;
            int up = getArea(grid, m, n, i - 1, j);
            int down = getArea(grid, m, n, i + 1, j);
            int left = getArea(grid, m, n, i, j - 1);
            int right = getArea(grid, m, n, i, j + 1);
            return up + down + left + right + 1;
        }
    }

    class Solution2 {
        // BFS: TC = O(n * m), SC = O(max(n, m))
        private int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int m = grid.length, n = grid[0].length;
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        max = Math.max(max, getArea(grid, m, n, i, j));
                    }
                }
            }
            return max;
        }

        private int getArea(int[][] grid, int m, int n, int i, int j) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i * n + j); // 2D -> 1D: [r][c] -> index = r * col + c
            grid[i][j] = 0;
            int area = 1;
            while (!queue.isEmpty()) {
                int index = queue.poll();
                for (int[] direction : DIRECTIONS) {
                    // 1D -> 2D: index -> [index/col][index%col]
                    int x = index / n + direction[0], y = index % n + direction[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                        queue.offer(x * n + y);
                        grid[x][y] = 0;
                        area++;
                    }
                }
            }
            return area;
        }
    }
}
