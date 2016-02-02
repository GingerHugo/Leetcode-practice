public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int count = nums.length;
        int i = 1;
        while (i < count) {
            if (nums[i] == nums[i - 1]) {
                if (i == count - 1) count--;
                else {
                    for (int j = i; j < count - 1; j++)
                        nums[j] = nums[j + 1];
                    count--;
                }
            }
            else i++;
        }
        return count;
    }
}