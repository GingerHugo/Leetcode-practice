public class Solution {
    public void sortColors(int[] nums) {
        int indexLeft = 0;
        int indexRight = nums.length;
        int tempNum;
        for (int i = 0; i < indexRight; i++) {
            if (nums[i] == 0) {
                tempNum = nums[i];
                nums[i] = nums[indexLeft];
                nums[indexLeft] = tempNum;
                indexLeft++;
            }
            else if (nums[i] == 2) {
                tempNum = nums[i];
                indexRight--;
                nums[i] = nums[indexRight];
                nums[indexRight] = tempNum;
                i--;
            }
        }
    }
}