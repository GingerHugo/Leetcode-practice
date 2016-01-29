public class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxValue = 0;
        int[] endElement = new int[nums.length];
        for (int num : nums) {
            int i = Arrays.binarySearch(endElement, 0, maxValue, num);
            if (i < 0) i = -(i + 1);
            endElement[i] = num;
            if (i == maxValue) maxValue++;
        }
        return maxValue;
    }
}