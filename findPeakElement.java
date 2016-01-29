public class Solution {
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
        while (indexLeft < indexRight) {
            int indexMid = (indexLeft + indexRight) / 2;
            if (nums[indexMid] > nums[indexMid - 1]) {
                if (nums[indexMid] <= nums[indexMid + 1]) {
                    indexLeft = indexMid + 1;
                }
                else {
                    return indexMid;
                }
            }
            else {
                indexRight = indexMid;
            }
        }
        if (indexLeft == 1) {
            return 1;
        }
        else {
            return (nums.length - 2);
        }
    }
}