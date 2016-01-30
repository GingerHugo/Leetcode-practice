public class Solution {
    public int minPathSum(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int[][] dpMatrix = new int[rowNum][colNum];
        dpMatrix[0][0] = grid[0][0];
        for (int j = 1; j < colNum; j++) {
            dpMatrix[0][j] = dpMatrix[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (j == 0) {
                    dpMatrix[i][j] = dpMatrix[i - 1][j] + grid[i][j];
                }
                else {
                    dpMatrix[i][j] = Math.min(dpMatrix[i][j - 1], dpMatrix[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dpMatrix[rowNum - 1][colNum - 1];
    }
}