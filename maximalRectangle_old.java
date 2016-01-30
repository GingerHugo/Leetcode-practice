public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[] left = new int[m];
        int[] right = new int[m];
        int[] height = new int[m];
        int result = 0;
        int preleft = 0;
        if (matrix[0][0] == '1') {
            right[0] = 1;
            result = 1;
            height[0] = 1;
        }
        else preleft = 1;
        
        for (int i = 1; i < m; i++) {
            if (matrix[0][i] == '1') {
                left[i] = Math.min(i, preleft);
                right[i] = Math.max(i + 1, right[i - 1]);
                height[i] = 1;
                result = Math.max(result, (right[i] - left[i]) * height[i]);
            }
            else preleft = i + 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(j, left[j]);
                    right[j] = Math.min(j + 1, right[j]);
                    height[j] = height[j] + 1;
                    result = Math.max(result, (right[j] - left[j]) * height[j]);
                }
            }
        }
        return result;
    }
}