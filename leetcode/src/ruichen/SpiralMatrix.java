package ruichen;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // #54 https://leetcode.com/problems/spiral-matrix/
    // Array, Simulation
    // TC = O(m * n), SC = O(m * n) (count result list, otherwise O(1))

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            int n = matrix.length, m = matrix[0].length;
            int top = 0, down = n - 1, left = 0, right = m - 1;
            while (top <= down && left <= right) {
                // left to right
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
                // top to down
                for (int i = top; i <= down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
                // right to left
                if (top <= down) {
                    for (int i = right; i >= left; i--) {
                        result.add(matrix[down][i]);
                    }
                    down--;
                }
                // down to top
                if (left <= right) {
                    for (int i = down; i >= top; i--) {
                        result.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            return result;
        }
    }
}
