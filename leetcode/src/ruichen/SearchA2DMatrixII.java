package ruichen;

public class SearchA2DMatrixII {

    // #240 https://leetcode.com/problems/search-a-2d-matrix-ii/
    // Array, Binary Search
    // TC = O(row + col), SC = O(1)

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int row = matrix.length - 1;
            int col = 0;
            while (row >= 0 && col < matrix[0].length) { // scan from bottom left or top right
                if (matrix[row][col] > target) {
                    row--;
                } else if (matrix[row][col] < target) {
                    col++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
