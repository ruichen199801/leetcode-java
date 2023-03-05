package ruichen;

public class PathWithMaximumGold {
    // DFS + Memoization
    // Choose any element as a start point: m * n
    // Each level: can go to 3 directions (cannot go back): 3^(m * n)
    // Time = O(m * n * 3 ^(m * n))
    // Space = O(m * n) (boolean array on heap) + O(m * n) (recursion stack) = O(m * n)
    class Solution {
        public int getMaximumGold(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int m = grid.length, n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > 0) {
                        max = Math.max(max, dfs(grid, i, j, visited));
                    }
                }
            }
            return max;
        }

        // case 1: out of bounds
        // case 2: visited[i][j] is true
        // case 3: grid[i][j] is 0
        private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
                return 0;
            }
            visited[i][j] = true;
            int up = dfs(grid, i, j - 1, visited);
            int left = dfs(grid, i - 1, j, visited);
            int down = dfs(grid, i, j + 1, visited);
            int right = dfs(grid, i + 1, j, visited);
            visited[i][j] = false; // reset and backtrack
            return grid[i][j] + Math.max(up, Math.max(left, Math.max(down, right)));
        }
    }
}
