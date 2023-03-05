package ruichen;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
    // See #189
    // TC = O(m * n), SC = O(m * n)
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (grid == null || grid.length == 0) {
                return res;
            }
            int m = grid.length, n = grid[0].length;
            int[] arr = new int[m * n];
            int index = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[index++] = grid[i][j];
                }
            }
            int len = arr.length; // m * n
            k %= len;
            // reverse-reverse trick
            reverse(arr, 0, len - k - 1);
            reverse(arr, len - k, len - 1);
            reverse(arr, 0, len - 1);
            index = 0;
            for (int i = 0; i < m; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(arr[index++]);
                }
                res.add(new ArrayList<>(row));
            }
            return res;
        }

        private void reverse(int[] arr, int left, int right) {
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
}
