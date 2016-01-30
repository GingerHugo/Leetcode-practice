public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (n * (n + 1)) / 2 - sum;
        // int left = 0;
        // int right = nums.length;
        // int index;
        // while (left < right) {
        //     int mid = (left + right) / 2;
        //     if (nums[mid] == mid) {
                
        //     }
        // }
    }
}