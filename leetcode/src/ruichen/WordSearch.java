package ruichen;

public class WordSearch {
    // TC = O(N * 3^L), N = # of cells on the board, L = word length
    // SC = O(L), maximum L recursion calls
    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (exist(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean exist(char[][] board, String word, int x, int y, int index) {
            if (index == word.length()) {
                return true;
            }
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index)) {
                return false;
            }
            // mark as visited
            char temp = board[x][y];
            board[x][y] = ' ';
            boolean exist = exist(board, word, x - 1, y, index + 1) ||
                    exist(board, word, x + 1, y, index + 1) ||
                    exist(board, word, x, y - 1, index + 1) ||
                    exist(board, word, x, y + 1, index + 1);
            // mark as unvisited
            board[x][y] = temp;
            return exist;
        }
    }
}
