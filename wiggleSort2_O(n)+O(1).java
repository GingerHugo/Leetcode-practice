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
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left + new Random().nextInt(right - left)];
        // nextInt does not include right - left
        int i = left; right -= 1;
        while (i <= right) {
            if (nums[i] > pivot)
                swap(nums, right--, i);
            else if (nums[i] < pivot)
                swap(nums, left++, i++);
            else i++;
        }
        return i - 1;
    }
    private int findKthMaximun(int k, int[] nums, int left, int right) {        
        int l = partition(nums, left, right);
        if (l == k)
            return nums[l];
        else if (l > k)
            return findKthMaximun(k, nums, left, l);
        else
            return findKthMaximun(k, nums, l + 1, right);
    }
    public void wiggleSort(int[] nums) {
        int mid = findKthMaximun(nums.length / 2, nums, 0, nums.length);
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