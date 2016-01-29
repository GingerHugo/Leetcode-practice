public class Solution {
    private int checkArray (int[] nums, int indexLeft, int indexRight) {
        if (indexLeft < indexRight) {
            int indexMid = (indexLeft + indexRight) / 2;
            if (nums[indexMid] > nums[indexMid - 1]) {
                if (nums[indexMid] <= nums[indexMid + 1]) {
                    indexLeft = indexMid + 1;
                    return checkArray(nums, indexLeft, indexRight);
                }
                else {
                    return indexMid;
                }
            }
            else {
                indexRight = indexMid;
                return checkArray(nums, indexLeft, indexRight);
            }
        }
        else if (indexLeft == 1) {  // Cannot find case
            return 1;
        }
        else {                      // Cannot find case
            return (nums.length - 2);
        }
    }
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int indexLeft = 1;
        int indexRight = nums.length - 1;
        return checkArray (nums, indexLeft, indexRight);
    }
}