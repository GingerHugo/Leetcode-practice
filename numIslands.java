public class Solution {
    private HashSet<Integer> historyRecord = new HashSet<>();
    private int lengthRow;
    private int lengthCol;
    private void labelArea(char[][] grid, int i, int j) {
        if ((i < lengthRow) && (j < lengthCol)) {
            int indexTemp = i * lengthCol + j;
            // To avoid dubplicate works.
            if ((grid[i][j] == '1') && (!historyRecord.contains(indexTemp))) {
                historyRecord.add(indexTemp);
                labelArea(grid, i + 1, j);
                labelArea(grid, i, j + 1);
                if (i > 0) {
                    labelArea(grid, i - 1, j);
                }
                if (j > 0) {
                    labelArea(grid, i, j - 1);
                }
            }  
        }
    }
    public int numIslands(char[][] grid) {
        int countResult = 0;
        int indexInt = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        lengthRow = grid.length;
        lengthCol = grid[0].length;
        for (int i = 0; i < lengthRow; i++) {
            for (int j = 0; j < lengthCol; j++) {
                if ((grid[i][j] == '1') && (!historyRecord.contains(indexInt))) {
                    countResult++;
                    labelArea(grid, i + 1, j);
                    labelArea(grid, i, j + 1);
                }
                indexInt++;
            }
        }
        return countResult;
    }
}