package ruichen;

public class SearchA2DMatrix {

	class Solution {
        
                // #74 https://leetcode-cn.com/problems/search-a-2d-matrix/
		// Binary Search
		// TC = O(m * n), SC = O(1)

		public boolean searchMatrix(int[][] matrix, int target) {
			int row = matrix.length, col = matrix[0].length;
			if (row == 0 || col == 0) {
				return false;
			}
			int left = 0, right = row * col - 1;
			while (left <= right) {
				int mid = left + (right - left) / 2;
				int r = mid / col, c = mid % col;
				if (matrix[r][c] == target) {
					return true;
				} else if (matrix[r][c] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			return false;
		}

	}

}
