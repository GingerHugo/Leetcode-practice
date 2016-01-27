public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        if (n == 0) return 1;
        int m = dungeon[0].length;
        int[][] DPtable = new int[n][m];
        DPtable[n - 1][m - 1] = Math.max(1, 1 - dungeon[n - 1][m - 1]); // positive 
        for (int i = n - 2; i >= 0; i--)
            DPtable[i][m - 1] = Math.max(1, DPtable[i + 1][m - 1] - dungeon[i][m - 1]);
        for (int i = m - 2; i >= 0; i--)
            DPtable[n - 1][i] = Math.max(1, DPtable[n - 1][i + 1] - dungeon[n - 1][i]);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                int temp = Math.min(DPtable[i + 1][j], DPtable[i][j + 1]) - dungeon[i][j];
                DPtable[i][j] = temp <= 0 ? 1 : temp;
            }
        }
        return DPtable[0][0];
    }
}