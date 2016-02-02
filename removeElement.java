public class Solution {
    public int removeElement(int[] nums, int val) {
        int left, right;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                while (left < right && nums[right] == val) right--;
                nums[left] = nums[right];
                if (left != right) right--;
                else break;
            }
            else left++;
        }
        return left;
    }
}