package ruichen;

public class IslandPerimeter {

    // #463 https://leetcode.com/problems/island-perimeter/
    // Array
    // TC = O(n * m), SC = O(1)

    class Solution {
        public int islandPerimeter(int[][] grid) {
            // perimeter = (4 - (up + down + left + right)) * n (substract 1 for each surrouding cell)
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int m = grid.length, n = grid[0].length;
            int result = 0;
            int up, down, left, right;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // if (cell is on 4 edges): substract = 0
                    //     else if (has adjacent cell on the specified direction): substract = 1
                    //          else: substract = 0
                    if (grid[i][j] == 1) {
                        up = i == 0 ? 0 : grid[i - 1][j];
                        down = i == m - 1 ? 0 : grid[i + 1][j];
                        left = j == 0 ? 0 : grid[i][j - 1];
                        right = j == n - 1 ? 0 : grid[i][j + 1];
                        result += 4 - (up + down + left + right);
                    }
                }
            }
            return result;
        }
    }
}
