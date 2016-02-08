public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m < 2 || n < 2) {
            return 1;
        }
        double result = (int)n;
        n--;
        for (int i = 2; i < m; i++) {
            result = result * (n + i) / i;
        }
        return (int)(result);
    }
}