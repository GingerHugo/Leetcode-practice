public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> setNum = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) setNum.remove(nums[i - k - 1]);
            if (!setNum.add(nums[i])) return true;
        }
        return false;
    }
}