public class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] DPtable = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            DPtable[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    DPtable[i][j] = DPtable[i - 1][j - 1] + DPtable[i - 1][j];
                else
                    DPtable[i][j] = DPtable[i - 1][j];
            }
        }
        return DPtable[n][m];
    }
}