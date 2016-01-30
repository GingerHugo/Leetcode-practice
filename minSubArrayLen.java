public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sumResultInt = 0;
        int targetLength = nums.length + 1;
        int leftIndex = 0;
        int rightIndex = 0;
        // int rightIndex = nums.length;
        while (rightIndex < nums.length) {
            sumResultInt += nums[rightIndex++];
            while (sumResultInt >= s) {
                targetLength = targetLength < (rightIndex - leftIndex)? targetLength : (rightIndex - leftIndex);
                sumResultInt -= nums[leftIndex++];
            }
        }
        return targetLength <= nums.length ? targetLength : 0;
    }
}