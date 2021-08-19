package ruichen;

public class RotateImage {

    // #48 https://leetcode.com/problems/rotate-image/
    // Array, Math
    // TC = O(n^2), SC = O(1)

    class Solution {
        public void rotate(int[][] matrix) {
            // 1. transpose (row to column)
            // 2. reverse (reverse each column)
            // process the matrix from outer to inner
            if (matrix == null || matrix.length == 0) {
                return;
            }
            int n = matrix.length;
            transposeMatrix(matrix, n);
            reverseMatrix(matrix, n);
        }

        private void transposeMatrix(int[][] matrix, int n) {
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    // swap diagonals, e.g. [0,1] and [1,0]
                    swap(matrix, i, j, j, i); // [i, j] <-> [j, i]
                }
            }
        }

        private void reverseMatrix(int[][] matrix, int n) {
            for (int i = 0; i < n; i++) {
                // on each row i, reverse column using two pointers j, k
                for (int j = 0, k = n - 1; j < k; j++, k--) {
                    swap(matrix, i, j, i, k); // [i, j] <-> [i, k]
                }
            }
        }

        private void swap(int[][] matrix, int i, int j, int k, int l) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[k][l];
            matrix[k][l] = tmp;
        }
    }
}
