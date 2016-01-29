public class Solution {
    private int rowLen;
    private int colLen;
    boolean[][] table;
    private boolean judge(int i, int j, char[][] board, String word) {
        if (word.length() == 0) return true;
        table[i][j] = true;
        boolean flag = false;
        if (i > 0 && board[i - 1][j] == word.charAt(0) && !table[i - 1][j] && judge(i - 1, j, board, word.substring(1)))
            flag = true;
        else if (j > 0 && board[i][j - 1] == word.charAt(0) && !table[i][j - 1] && judge(i, j - 1, board, word.substring(1)))
            flag = true;
        else if (i < rowLen - 1 && board[i + 1][j] == word.charAt(0) && !table[i + 1][j] && judge(i + 1, j, board, word.substring(1)))
            flag = true;
        else if (j < colLen - 1 && board[i][j + 1] == word.charAt(0) && !table[i][j + 1] && judge(i, j + 1, board, word.substring(1)))
            flag = true;
        table[i][j] = false;
        return flag;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            rowLen = board.length;
            colLen = board[0].length;
            table = new boolean[rowLen][colLen];
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == word.charAt(0) &&
                    judge(i, j, board, word.substring(1))) {
                    return true;
                }
            }
        }
        return false;
    }
}