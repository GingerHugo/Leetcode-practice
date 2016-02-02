public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length < 3) return 0;
        int result = nums[0] + nums[1] + nums[2];
        int gap = Math.abs(result - target);
        for (int i = 0; i < nums.length - 2; i++) {
            // if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            int leftPart = target - nums[i];
            while (left < right) {
                int temp = Math.abs(nums[left] + nums[right] - leftPart);
                if (temp == 0) return target;
                if (temp < gap) {
                    result = nums[left] + nums[right] + nums[i];
                    gap = temp; // Don't forget about the compare value
                }
                if (nums[left] + nums[right] > leftPart) right--;
                else left++;
            }
        }
        return result;
    }
}