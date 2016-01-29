public class Solution {
    private void changeState (int[] arrayIndex, int state) {
        if (state < 2) {
            arrayIndex[(state + 1) % 2] += 1;
        }
        else {
            arrayIndex[(state + 1) % 2] -= 1; 
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] resultList = new int[n][n];
        int[] arrayIndex = new int[2];
        int state = 0;
        int upperBound = n - 1;
        int countInt = 1;
        while (upperBound >= 0) {
            if (upperBound == 0) {
                resultList[arrayIndex[0]][arrayIndex[1]] = countInt;
                break;
            }
            for (int i = 0; i < upperBound; i++) {
                resultList[arrayIndex[0]][arrayIndex[1]] = countInt;
                countInt++;
                changeState(arrayIndex, state);
            }
            state++;
            // changeState(arrayIndex, state);
            // state = state % 4;
            if ((state % 4) == 0) {
                upperBound -= 2;
                state = state % 4;
                arrayIndex[0] += 1;
                arrayIndex[1] += 1;
            }
        }
        return resultList;
    }
}