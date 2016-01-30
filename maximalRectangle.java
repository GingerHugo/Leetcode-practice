public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[] left = new int[m];
        int[] right = new int[m];
        int[] height = new int[m];
        Arrays.fill(right, m); int result = 0;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur); 
                    height[j]++;
                }
                else {
                    left[j] = height[j] = 0;
                    cur = j + 1;
                }
            }
            cur = m;
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur);
                    result = Math.max(result, (right[j] - left[j]) * height[j]);
                }
                else {
                    right[j] = m;
                    cur = j;
                }
            }
        }
        return result;
    }
}