package ruichen;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    // TC = O(n! * n^2), SC = O(n^2)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            char[][] cur = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cur[i][j] = '.';
                }
            }
            dfs(0, n, cur, result);
            return result;
        }

        private void dfs(int row, int n, char[][] cur, List<List<String>> result) {
            if (row == n) {
                result.add(toList(cur));
                return;
            }
            for (int col = 0; col < n; col++) {
                if (valid(row, col, n, cur)) {
                    cur[row][col] = 'Q';
                    dfs(row + 1, n, cur, result);
                    cur[row][col] = '.';
                }
            }
        }

        private boolean valid(int row, int col, int n, char[][] cur) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < n; c++) {
                    if (cur[r][c] == 'Q' && (c == col || Math.abs(col - c) == row - r)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private List<String> toList(char[][] cur) {
            List<String> list = new ArrayList<>();
            for (char[] arr : cur) {
                list.add(new String(arr));
            }
            return list;
        }
    }
}
