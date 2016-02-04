public class Solution {
    public int maxSubArray(int[] nums) {
        // TLE version
        int[] table = Arrays.copyOf(nums, nums.length);
        int count = table[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j + i < nums.length; j++) {
                if (j - i >= 0) {
                    table[j] = nums[j - i] + table[j];
                    if (j + i < nums.length) {
                        table[j] = Math.max(table[j], nums[j + i] + table[j]);
                    }
                }
                else if (j + i < nums.length) {
                    table[j] = nums[j + i] + table[j];
                }
                count = Math.max(count, table[j]);
            }
        }
        return count;
    }
}