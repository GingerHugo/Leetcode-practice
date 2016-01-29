public class Solution {
    private int[] countOn(int[][] board, int i, int j, int n, int m) {
        int[] counting = new int[2];
        if (i > 0) {
            counting[board[i - 1][j] & 1] += 1; 
            if (j > 0) counting[board[i - 1][j - 1] & 1] += 1;
        }
        if (j > 0) {
            counting[board[i][j - 1] & 1] += 1;
            if (i < n) counting[board[i + 1][j - 1] & 1] += 1;
        }
        if (i < n) {
            counting[board[i + 1][j] & 1] += 1;
            if (j < m) counting[board[i + 1][j + 1] & 1] += 1;
        }
        if (j < m) {
            counting[board[i][j + 1] & 1] += 1;
            if (i > 0) counting[board[i - 1][j + 1] & 1] += 1;
        }
        return counting;
    }
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[] result = countOn(board, i, j, board.length - 1, board[0].length - 1);
                if (board[i][j] == 0 && result[1] == 3) {
                    board[i][j] = 2;
                }
                else if (board[i][j] == 1 && (result[1] == 2 || result[1] == 3)) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
}