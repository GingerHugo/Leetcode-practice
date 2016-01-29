public class Solution {
    private int countOn(int[][] board, int indexI, int indexJ, int n, int m) {
        int counting = 0;
        for (int i = Math.max(indexI - 1, 0); i < Math.min(n, indexI + 2); i++) {
            for (int j = Math.max(indexJ - 1, 0); j < Math.min(m, indexJ + 2); j++) {
                counting += board[i][j] & 1;
            }
        }
        counting -= board[indexI][indexJ];
        return counting;
    }
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int result = countOn(board, i, j, board.length, board[0].length);
                if (board[i][j] == 0 && result == 3) {
                    board[i][j] = 2;
                }
                else if (board[i][j] == 1 && (result == 2 || result == 3)) {
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