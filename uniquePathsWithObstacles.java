public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if (n == 0) {
            return 0;
        }
        int m = obstacleGrid[0].length;
        int[] dp = new int[m];
        dp[0] = 1 - obstacleGrid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[j] = obstacleGrid[i][j] == 0 ? dp[j - 1] : 0;
                }
                else if (j == 0) {
                    dp[j] = obstacleGrid[i][j] == 0 ? dp[j] : 0;
                }
                else {
                    dp[j] = obstacleGrid[i][j] == 0 ? dp[j] + dp[j - 1] : 0;
                }
            }
        }
        return dp[m - 1];
    }
}