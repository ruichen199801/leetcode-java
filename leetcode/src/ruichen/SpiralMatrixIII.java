package ruichen;

public class SpiralMatrixIII {

    // #885 https://leetcode.com/problems/spiral-matrix-iii/
    // Array, Simulation
    // TC = O(max(n, m)^2), SC = O(n * m)

    class Solution {
        public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
            // (x, y) -> r1 -> d1 -> l2 -> u2 -> r3 -> d3 -> ...
            // 1, 2, 3, 4, 5, 6, ... , n
            // 1, 1, 2, 2, 3, 3, ... , n/2 + 1
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // clockwise, x: row, y: col (reversed coordinate)
            int[][] result = new int[rows * cols][2];
            int x = rStart, y = cStart, turnCount = 0, resCount = 0, dir = 0;
            while (resCount < rows * cols) {
                for (int i = 0; i < turnCount / 2 + 1; i++) {
                    if (x >= 0 && x < rows && y >= 0 && y < cols) {
                        result[resCount++] = new int[] {x, y};
                    }
                    x += directions[dir][0];
                    y += directions[dir][1];
                }
                dir = (dir + 1) % 4;
                turnCount++;
            }
            return result;
        }
    }
}
