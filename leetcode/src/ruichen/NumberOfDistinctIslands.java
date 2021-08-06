package ruichen;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

    // #694 https://leetcode.com/problems/number-of-distinct-islands/
    // Depth-first Search
    // TC = O(n * m), SC = O(n * m)

    class Solution {
        public int numDistinctIslands(int[][] grid) {
            // differentiate islands by direction of recursive calls
            // 'X': start
            // 'O': out of bounds or 0
            // 'U': up
            // 'R': right
            // 'D': down
            // 'L': left
            // don't forget to change land to water after visited
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int m = grid.length, n = grid[0].length;
            Set<String> islands = new HashSet<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        String island = drawIsland(grid, m, n, i, j, "X");
                        islands.add(island);
                    }
                }
            }
            return islands.size();
        }

        private String drawIsland(int[][] grid, int m, int n, int i, int j, String str) {
            if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
                return "O";
            }
            grid[i][j] = 0;
            String up = drawIsland(grid, m, n, i - 1, j, "U");
            String right = drawIsland(grid, m, n, i, j + 1, "R");
            String down = drawIsland(grid, m, n, i + 1, j, "D");
            String left = drawIsland(grid, m, n, i, j - 1, "L");
            return str + up + right + down + left;
        }
    }
}
