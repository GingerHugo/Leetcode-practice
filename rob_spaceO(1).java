public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int robYes = nums[0];
        int robNo = 0;
        for (int i = 1; i < nums.length; i++) {
            int newYes = robNo + nums[i];
            robNo = Math.max(robYes, robNo);
            robYes = newYes;
        }
        return Math.max(robYes, robNo);
    }
}