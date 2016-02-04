public class Solution {
    public int maxSubArray(int[] nums) {
        int largeEnd = nums[0];
        int largeMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            largeEnd = Math.max(largeEnd + nums[i], nums[i]);
            largeMax = Math.max(largeMax, largeEnd);
        }
        return largeMax;
    }
}