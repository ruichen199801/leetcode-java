package ruichen;

public class UniquePathsIII {

    // #980 https://leetcode.com/problems/unique-paths-iii/
    // Array, Depth-first Search
    // TC = O(3^n) (brute-force DFS, 4^n -> 3^n), SC = O(n) (recursion stack)

    class Solution {

        private int count = 0;
        private int sx = 0, sy = 0;
        private int squaresToVisit = 1; // count start point into squares to visit

        public int uniquePathsIII(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            // find start point + count 0 squares to visit in dfs
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        squaresToVisit++;
                    } else if (grid[i][j] == 1) {
                        sx = i;
                        sy = j;
                    }
                }
            }
            dfs(grid, sx, sy);
            return count;
        }

        private void dfs(int[][] grid, int x, int y) {
            // check invalid conditions: (x, y) goes out of bound || isObstacle || visited
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) {
                return;
            }
            // check end point
            if (grid[x][y] == 2) {
                // only update answer when all valid squares have been visited
                if (squaresToVisit == 0) {
                    count++;
                }
                return;
            }
            // mark as visited both in squaresToVisit and value in grid[x][y]
            squaresToVisit--;
            grid[x][y] = -2;

            // explore 4 directions
            dfs(grid, x - 1, y);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x, y + 1);

            // unmark both in squaresToVisit and value in grid[x][y]
            squaresToVisit++;
            grid[x][y] = 0;
        }
    }
}
