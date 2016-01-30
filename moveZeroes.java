public class Solution {
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 0) {
        		for (int j = i + 1; j < nums.length; j++) {
        			if (nums[j] != 0) {
        				swap(nums, i, j);
        				break;
        			}
        		}
        	}
        }
    }
}