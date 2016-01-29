import java.util.Random;

public class Solution {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int quickSelect(int left, int right, int k, int[] nums) {
        // Actually the partition;
        Random randomGenerator = new Random();
        int randomInt = right > left ? randomGenerator.nextInt(right - left) + left : left;
        int pivot = nums[randomInt];
        int i = left;
        int j = left;
        int m = right;
        while (j <= m) {
            if (nums[j] < pivot) {
                swap(i++, j++, nums);
            }
            else if (nums[j] > pivot) {
                swap(j, m--, nums);
            }
            else j++;
        } 
        if (nums.length - i == k) {
            return nums[i];
        }
        else if (nums.length - i > k) {
            return quickSelect (i + 1, right, k, nums);
        }
        else {
            return quickSelect (left, i - 1, k, nums);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(0, nums.length - 1, k, nums);
    }
}