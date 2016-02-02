public class Solution {
    private void swap4 (int[][] matrix, int[] arrayIndex) {
        int iCountTemp = matrix[arrayIndex[0]][arrayIndex[1]];
        matrix[arrayIndex[0]][arrayIndex[1]] = matrix[arrayIndex[6]][arrayIndex[7]];
        matrix[arrayIndex[6]][arrayIndex[7]] = matrix[arrayIndex[4]][arrayIndex[5]];
        matrix[arrayIndex[4]][arrayIndex[5]] = matrix[arrayIndex[2]][arrayIndex[3]];
        matrix[arrayIndex[2]][arrayIndex[3]] = iCountTemp;
    }
    public void rotate(int[][] matrix) {
        if (matrix.length < 1) {
            return;
        }
        int numLength = matrix.length - 1;
        int[] arrayIndex = new int[8];
        for (int i = 3; i < 7; i++) {
            arrayIndex[i] = numLength;
        }
        while (numLength > 0) {
            for (int i = 0; i < numLength; i++) {
                swap4 (matrix, arrayIndex);
                arrayIndex[1]++;
                arrayIndex[2]++;
                arrayIndex[5]--;
                arrayIndex[6]--;
            }
            numLength -= 2;
            for (int i = 1; i < 5; i++) {
                arrayIndex[i]--;
            }
            for (int i = 5; i < 9; i++) {
                arrayIndex[i % 8]++;
            }
            int iTemp1 = arrayIndex[6];
            int iTemp2 = arrayIndex[7];
            for (int i = 5; i >= 0; i--) {
                arrayIndex[i + 2] = arrayIndex[i];
            }
            arrayIndex[0] = iTemp1;
            arrayIndex[1] = iTemp2;
        }
        return;
    }
}