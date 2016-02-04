public class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = costs[i][j] + 
                Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
            }
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}