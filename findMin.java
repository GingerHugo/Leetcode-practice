public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int pivotInt = nums[0];
        int leftIndex = 0;
        int righIndex = nums.length;
        while (leftIndex < righIndex) {
            int middIndex = (leftIndex + righIndex) / 2;
            if (nums[middIndex] >= pivotInt) {
                leftIndex = leftIndex + 1;
            }
            else {
                pivotInt = nums[middIndex];
                righIndex = middIndex;
            }
        }
        return pivotInt;
    }
}