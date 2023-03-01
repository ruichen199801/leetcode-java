package ruichen;

import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill {

    // #733 https://leetcode.com/problems/flood-fill/
    // Breadth-first Search, Depth-first Search
    // See #200

    class Solution1 {
        // DFS: TC = O(mn), SC = O(mn)
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image[sr][sc] == newColor) {
                return image;
            }
            dfs(image, sr, sc, image[sr][sc], newColor);
            return image;
        }

        private void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
            // Check if out of bounds or if pixel color is not the old color
            if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor) {
                return;
            }
            // Set pixel color to new color
            image[row][col] = newColor;
            // Recursively call DFS on neighboring pixels
            dfs(image, row + 1, col, oldColor, newColor);
            dfs(image, row - 1, col, oldColor, newColor);
            dfs(image, row, col + 1, oldColor, newColor);
            dfs(image, row, col - 1, oldColor, newColor);
        }
    }

    class Solution2 {
        // BFS: TC = O(mn), SC = O(mn)
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int m = image.length;
            int n = image[0].length;
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int oldColor = image[sr][sc];
            if (oldColor == newColor) {
                return image;
            }
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{sr, sc});
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                image[row][col] = newColor;
                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && image[newRow][newCol] == oldColor) {
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            return image;
        }
    }

}
