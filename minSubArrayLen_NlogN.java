public class Solution {
    private int binarySearch(int left, int right, int target, int[] sums) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    public int minSubArrayLen(int s, int[] nums) {
        int lenGap = Integer.MAX_VALUE;
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];

        for (int i = 0; i < nums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, s + sums[i], sums);
            if (end == sums.length) break;
            lenGap = Math.min(lenGap, end - i);
        }
        return lenGap == Integer.MAX_VALUE ? 0 : lenGap;
    }
}