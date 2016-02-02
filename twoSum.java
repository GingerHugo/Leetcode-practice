public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> indexTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexTable.containsKey(nums[i])) indexTable.get(nums[i]).add(i + 1);
            else {
                List<Integer> indexList = new LinkedList<>();
                indexList.add(i + 1);
                indexTable.put(nums[i], indexList);
            }
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < nums.length - 1 && j > 0) {
            if (nums[i] + nums[j] > target) j--;
            else if (nums[i] + nums[j] < target) i++;
            else {
                break;
            }
        }
        int[] result = new int[2];
        int left, right;
        if (nums[i] == nums[j]) {
            left = indexTable.get(nums[i]).get(0);
            right = indexTable.get(nums[i]).get(1);
        }
        else {
            left = indexTable.get(nums[i]).get(0);
            right = indexTable.get(nums[j]).get(0);
        }
        result[0] = Math.min(left, right);
        result[1] = Math.max(left, right);
        return result;
    }
}