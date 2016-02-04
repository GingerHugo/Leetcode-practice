public class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            if (i > 0 && pArr[i] == '*') {
                dp[0][i + 1] = dp[0][i - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pArr[j] == '*') {
                    dp[i + 1][j + 1] = j > 0 && dp[i + 1][j - 1] || dp[i + 1][j] ||
                    j > 0 && dp[i][j + 1] && (sArr[i] == pArr[j - 1] || pArr[j - 1] == '.');
                    // The third condition cannot be dp[i][j - 1] but should be dp[i][j + 1]
                }
                else {
                    dp[i + 1][j + 1] = dp[i][j] && (sArr[i] == pArr[j] || pArr[j] == '.');
                }
            }
        }
        return dp[n][m];
    }
}