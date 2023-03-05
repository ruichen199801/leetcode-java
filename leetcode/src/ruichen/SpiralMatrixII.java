package ruichen;

public class SpiralMatrixII {
    // TC = O(n^2), SC = O(n^2) (count result matrix, otherwise O(1))
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            int top = 0, down = n - 1, left = 0, right = n - 1;
            int num = 1;
            while (top <= down && left <= right) {
                // left to right
                for (int i = left; i <= right; i++) {
                    result[top][i] = num;
                    num++;
                }
                top++;
                // top to down
                for (int i = top; i <= down; i++) {
                    result[i][right] = num;
                    num++;
                }
                right--;
                // right to left (make sure x[down][x] is valid)
                if (top <= down) {
                    for (int i = right; i >= left; i--) {
                        result[down][i] = num;
                        num++;
                    }
                    down--;
                }
                // down to top (make sure x[x][left] is valid)
                if (left <= right) {
                    for (int i = down; i >= top; i--) {
                        result[i][left] = num;
                        num++;
                    }
                    left++;
                }
            }
            return result;
        }
    }
}
