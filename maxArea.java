public class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int[] arrayIndex = new int[2];
        arrayIndex[0] = 0;
        arrayIndex[1] = height.length - 1;
        int[] arrayCalculate = new int[2];
        arrayCalculate[0] = 1;
        arrayCalculate[1] = -1;
        int minIndex = height[arrayIndex[0]] < height[arrayIndex[1]] ? 0 : 1;
        int minSide = height[arrayIndex[minIndex]];
        int maxResult = minSide * (height.length - 1);
        while (arrayIndex[0] < arrayIndex[1]) {
            arrayIndex[minIndex] += arrayCalculate[minIndex];
            if (height[arrayIndex[minIndex]] > minSide) {
                minIndex = height[arrayIndex[minIndex]] < height[arrayIndex[(minIndex + 1) % 2]] ? minIndex : ((minIndex + 1) % 2);
                minSide = height[arrayIndex[minIndex]];
                int maxResultTemp = minSide * (arrayIndex[1] - arrayIndex[0]);
                if (maxResultTemp > maxResult) {
                    maxResult = maxResultTemp;
                }
            }
        }
        return maxResult;
    }
}