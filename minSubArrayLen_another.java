public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int lenGap = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                lenGap = Math.min(lenGap, i + 1 - start);
                sum -= nums[start++];
            }
        }
        return lenGap == Integer.MAX_VALUE ? 0 : lenGap;
    }
}