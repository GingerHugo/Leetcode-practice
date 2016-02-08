public class Solution {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int left = 0;
        int mid = left;
        int right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(left++, mid++, nums);
            }
            else if (nums[mid] == 2) {
                swap(mid, right--, nums);
            }
            else {
                mid++;
            }
        }
    }
}