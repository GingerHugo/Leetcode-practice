public class Solution {
    public int[] productExceptSelf(int[] nums) {
        long result = 1;
        int count = 0;
        for (int num : nums) {
            if (num != 0) result *= (long)num;
            else count += 1;
        }
        int[] resultList = new int[nums.length];
        if (count >= 2) return resultList;
        else if (count == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) resultList[i] = (int)(result);
            }
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                resultList[i] = (int)(result / nums[i]);
            }
        }
        return resultList;
    }
}