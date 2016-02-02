public class Solution {
    // This method cannot be accepted as duplicate cases!
    private void swap (int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // Set<String> table = new HashSet<>();
    // private int count = 0;
    private void permutation(int left, int right, int[] nums, List<List<Integer>> result) {
        if (left == nums.length - 1) {
            List<Integer> temp = new LinkedList<>();
            for (int num : nums) {
                temp.add(num);
            }
            result.add((temp));
            // System.out.println(++count);
            return;
        }
        for (int i = left; i < right; i++) {
            if (i != left && nums[i] == nums[left]) {
                continue;
            }
            swap(i, left, nums);
            permutation(left + 1, right, nums, result);
            swap(i, left, nums);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        permutation(0, nums.length, nums, result);
        return result;
    }
}