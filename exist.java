public class Solution {
    private char[] w;
    private boolean judge(int i, int j, char[][] board, int n) {
        if (w.length == n) return true;
        board[i][j] ^= 256;
        boolean flag = false;
        if (i > 0 && board[i - 1][j] == w[n] && judge(i - 1, j, board, n + 1))
            flag = true;
        else if (j > 0 && board[i][j - 1] == w[n] && judge(i, j - 1, board, n + 1))
            flag = true;
        else if (i < board.length - 1 && board[i + 1][j] == w[n] && judge(i + 1, j, board, n + 1))
            flag = true;
        else if (j < board[0].length - 1 && board[i][j + 1] == w[n] && judge(i, j + 1, board, n + 1))
            flag = true;
        board[i][j] ^= 256;
        return flag;
    }

    public boolean exist(char[][] board, String word) {
        w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == w[0] &&
                    judge(i, j, board, 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}