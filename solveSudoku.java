public class Solution {
    private boolean checkSudoku(char[][] board, int i, int j, char c) {
        for (int n = 0; n < board[0].length; n++) if (board[i][n] == c) return false;
        for (int n = 0; n < board.length; n++) if (board[n][j] == c) return false;
        for (int n = (i / 3) * 3; n < (i / 3) * 3 + 3; n++) {
            for (int m = (j / 3) * 3; m < (j / 3) * 3 + 3; m++) {
                if (board[n][m] == c) return false;
            }
        }
        return true;
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (checkSudoku(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        solve(board);
    }
}