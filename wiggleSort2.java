import java.util.*;
public class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int indexConvert(int num, int n) {
        return (num * 2 + 1) % (n | 1);
    }    
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int i, j, n;
        i = 0;
        j = n = nums.length - 1;
        while (j >= i) {
            if (nums[indexConvert(j, nums.length)] > mid)
                swap(nums, indexConvert(i++, nums.length), indexConvert(j, nums.length));
            else if (nums[indexConvert(j, nums.length)] < mid)
                swap(nums, indexConvert(n--, nums.length), indexConvert(j--, nums.length));         
            else j--;
        }
    }
}