public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        Set<Integer> numSet = new HashSet<Integer>();
        int count = nums.length;
        int i = 1;
        while (i < count) {
            if (nums[i] == nums[i - 1]) {
                if (numSet.contains(nums[i])) {
                    if (i != count - 1)
                        for (int j = i; j < count - 1; j++)
                            nums[j] = nums[j + 1];
                    count--;
                }
                else numSet.add(nums[i++]);
            }
            else i++;
        }
        return count;
    }
}