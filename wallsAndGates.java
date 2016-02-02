public class Solution {
    private int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private void BFS(int i, int j, int[][] rooms) {
        for (int[] dir : direction) {
            if (i + dir[0] >= 0 && i + dir[0] < rooms.length && 
                j + dir[1] >= 0 && j + dir[1] < rooms[0].length) {
                if (rooms[i + dir[0]][j + dir[1]] > rooms[i][j] + 1) {
                    rooms[i + dir[0]][j + dir[1]] = rooms[i][j] + 1;
                    BFS(i + dir[0], j + dir[1], rooms);
                }
            }
        }
    }
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[0].length; j++)
                if (rooms[i][j] == 0)
                    BFS(i, j, rooms);
    }
}