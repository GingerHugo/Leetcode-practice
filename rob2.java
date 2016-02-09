public class Solution {
    private int robPartial(int[] nums, int left, int right) {
        int robYes = nums[left];
        int robNo = 0;
        for (int i = left + 1; i < right; i++) {
            int newYes = robNo + nums[i];
            robNo = Math.max(robNo, robYes);
            robYes = newYes;
        }
        return Math.max(robYes, robNo);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        else if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robPartial(nums, 0, nums.length - 1), robPartial(nums, 1, nums.length));
    }
}