public class Solution {
    private void insert(int m, int[] nums, int i, int upper) {
        for (int j = upper; j > i; j--)
            nums[j] = nums[j - 1];
        nums[i] = m;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = 0; i < m + j; i++)
            if (j < n && nums2[j] < nums1[i])
                insert(nums2[j], nums1, i, m + j++);
        while (j < n)
            insert(nums2[j], nums1, m + j++, 0);
    }
}