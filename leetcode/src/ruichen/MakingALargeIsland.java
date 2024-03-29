package ruichen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {
    // TC = O(n^2), SC = O(n^2) (recursion depth)
    class Solution {
        private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int largestIsland(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int max = 0, islandId = 2, m = grid.length, n = grid[0].length;
            Map<Integer, Integer> map = new HashMap<>();

            // explore all 1s to mark connected islands as unique incremental ids
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int size = getSize(grid, i, j, islandId); // recursively get size and mark connected islands
                        max = Math.max(max, size); // update global max
                        map.put(islandId++, size); // store <islandId, size>
                    }
                }
            }

            // explore all 0s to compute possible max sizes after changing one 0 to 1
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        Set<Integer> set = new HashSet<>();
                        for (int[] direction : directions) {
                            int x = i + direction[0], y = j + direction[1]; // explore all four neighbors of the 0
                            if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != 0) { // x, y legal + not 0s + different ids
                                set.add(grid[x][y]);
                            }
                        }

                        int sum = 1; // change one 0 to 1
                        for (int id : set) {
                            sum += map.get(id);
                        }
                        max = Math.max(max, sum); // compare the sum after applying 0-to-1 strategy with the native max size
                    }
                }
            }

            return max;
        }

        private int getSize(int[][] grid, int i, int j, int islandId) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) { // i, j illegal + 0s + marked before
                return 0;
            }
            grid[i][j] = islandId; // mark connected islands and avoid repeat calls (compute size only when grid[i][j] == 1)
            int up = getSize(grid, i - 1, j, islandId);
            int down = getSize(grid, i + 1, j, islandId);
            int left = getSize(grid, i, j - 1, islandId);
            int right = getSize(grid, i, j + 1, islandId);
            return up + down + left + right + 1;
        }
    }
}
