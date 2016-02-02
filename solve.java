public class Solution {
    private void performDFS(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '+';
        }
        if (i > 1 && board[i - 1][j] == 'O') {
            performDFS(board, i - 1, j);
        }
        if (j > 1 && board[i][j - 1] == 'O') {
            performDFS(board, i, j - 1);
        }
        if (i < board.length - 2 && board[i + 1][j] == 'O') {
            performDFS(board, i + 1, j);
        }
        if (j < board[0].length - 2 && board[i][j + 1] == 'O') {
            performDFS(board, i, j + 1);
        }
    }

    public void solve(char[][] board) {
        // Map<Integer, Boolean> truthTable = new HashMap<>();
        int rowNum = board.length;
        if (rowNum <= 2) {
            return;
        }
        int colNum = board[0].length;
        if (colNum <= 2) {
            return;
        }

        for (int j = 0; j < colNum; j++) {
            if (board[0][j] == 'O') {
                performDFS(board, 0, j);
            }
            if (board[rowNum - 1][j] == 'O') {
                performDFS(board, rowNum - 1, j);
            }
        }

        for (int i = 0; i < rowNum; i++) {
            if (board[i][0] == 'O') {
                performDFS(board, i, 0);
            }
            if (board[i][colNum - 1] == 'O') {
                performDFS(board, i, colNum - 1);
            }
        }

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}