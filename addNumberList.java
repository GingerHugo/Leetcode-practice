public class Solution {
    public boolean addNumberList(int[] nums, int target) {
        if (nums.length < 2) {
            return nums[0] == target;
        }
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target && left <= i) {
                if (sum == target) {
                    return true;
                }
                sum -= nums[left++];
            }
        }
        return false;
    }
}