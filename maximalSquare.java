public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] leftArr = new int[matrix[0].length];
        int[] rightArr = new int[matrix[0].length];
        for (int i = 0; i < rightArr.length; i++) rightArr[i] = matrix[0].length;
        int[] heightArr = new int[matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[0].length;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    leftArr[j] = Math.max(leftArr[j], left);
                    heightArr[j]++;
                }
                else {
                    left = j + 1;
                    leftArr[j] = 0;
                    heightArr[j] = 0;
                }
            }
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    rightArr[j] = Math.min(right, rightArr[j]);
                    int temp = Math.min(heightArr[j], (rightArr[j] - leftArr[j]));
                    result = Math.max(result, temp * temp);
                }
                else {
                    rightArr[j] = matrix[0].length;
                    right = j;
                }
            }
        }
        return result;
    }
}