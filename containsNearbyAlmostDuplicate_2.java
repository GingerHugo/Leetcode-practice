public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums == null) return false;
        TreeSet<Integer> numSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) numSet.remove(nums[i - k - 1]);
            Integer large = numSet.floor(nums[i] + t);  // Avoid Long, if none return null
            Integer small = numSet.ceiling(nums[i] - t);// floor and ceiling only exists in TreeSet and not in Set
            // >=, equal case, only Integer can get null
            if (large != null && large >= nums[i] || small != null && nums[i] >= small) {
                return true;
            }
            numSet.add(nums[i]);
        }
        return false;
    }
}