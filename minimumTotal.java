public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Top-down Method
        int[] tempSum = new int[triangle.size()];
        int level = 0;
        for (List<Integer> row : triangle) {
            int index = 0;
            int previous = tempSum[0];
            for (int number : row) {
                if(index == 0) {
                    tempSum[0] = number + tempSum[0];
                }
                else if (index == level) {
                    tempSum[index] = number + previous;
                }
                else {
                    int tempSumNum = Math.min(tempSum[index], previous) + number;
                    previous = tempSum[index];
                    tempSum[index] = tempSumNum;
                }
                index++;
            }
            level++;
        }
        int result = tempSum[0];
        for (int tempInt : tempSum) {
            result = Math.min(result, tempInt);
        }
        return result;
    }
}