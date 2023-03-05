package ruichen;

public class LongestIncreasingPathInAMatrix {
    // DFS + Memoization: use memoization to cache results of previous recursive calls, otherwise stack overflow
    // TC = O(m * n), SC = O(m * n)
    class Solution {
        private int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int m = matrix.length, n = matrix[0].length;
            int[][] cache = new int[m][n];
            int longestPath = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (cache[i][j] == 0) {
                        int longest = getPath(matrix, cache, m, n, i, j);
                        longestPath = Math.max(longestPath, longest);
                    }
                }
            }
            return longestPath;
        }

        private int getPath(int[][] matrix, int[][] cache, int m, int n, int i, int j) {
            if (cache[i][j] > 0) {
                return cache[i][j];
            }
            int max = 0;
            for (int[] direction : DIRECTIONS) {
                int x = direction[0] + i, y = direction[1] + j;
                if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
                    int longest = getPath(matrix, cache, m, n, x, y);
                    max = Math.max(max, longest); // max(up, down, left, right)
                }
            }
            cache[i][j] = max + 1;
            return cache[i][j];
        }
    }
}
