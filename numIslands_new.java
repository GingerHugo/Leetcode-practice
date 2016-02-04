public class Solution {
    private void dfsSearch(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        if (i > 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
            dfsSearch(i - 1, j, grid, visited);
        }
        if (j > 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
            dfsSearch(i, j - 1, grid, visited);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
            dfsSearch(i + 1, j, grid, visited);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
            dfsSearch(i, j + 1, grid, visited);
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfsSearch(i, j, grid, visited);
                }
            }
        }
        return count;
    }
}