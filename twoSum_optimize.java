public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int [2];
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(target - nums[i])) {
                result[0] = table.get(target - nums[i]) + 1;
                result[1] = i + 1;
                return result;
            }
            table.put(nums[i], i);
        }
        return result;
    }
}