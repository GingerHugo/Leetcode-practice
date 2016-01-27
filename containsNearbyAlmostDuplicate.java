public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> treeNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long num = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = num / ((long)t + 1);
            if (treeNum.size() > k) {
                treeNum.remove(((long)nums[i - k - 1] - Integer.MIN_VALUE) / ((long)t + 1));
            }
            if (treeNum.containsKey(bucket) || 
                treeNum.containsKey(bucket + 1) && treeNum.get(bucket + 1) - num <= t || 
                treeNum.containsKey(bucket - 1) && num - treeNum.get(bucket - 1) <= t) {
                return true;
            }
            treeNum.put(bucket, num);
        }
        return false;
    }
}