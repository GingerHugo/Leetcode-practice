public class Solution {
    public int maxCoins(int[] nums) {
        int n = 1;
        int[] candidate = new int[nums.length + 2]; 
        for (int num : nums) {
            if (num > 0) candidate[n++] = num;
        }
        candidate[0] = candidate[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++) {
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], candidate[left] * candidate[i] * candidate[right] 
                        + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }
}