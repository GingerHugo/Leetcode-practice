public class Solution {
    public boolean addNumberList(int[] nums, int target) {
        if (nums.length < 2) {
            return nums[0] == target;
        }
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < target) {
                sum += nums[i];
            }
            if (sum == target) {
                return true;
            }
            else if (sum > target) {
                while (left <= i) {
                    sum -= nums[left++];
                    if (sum == target) {
                        return true;
                    }
                    else if (sum < target) {
                        break;
                    }
                }
            }
        }
        return false;
    }
}