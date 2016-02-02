public class Solution {
    Set<String> table = new HashSet<>();
    private List<List<Integer>> permutation(int index, int[] nums, List<List<Integer>> pre) {
        if (index == nums.length) {
            return pre;
        }
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (List<Integer> listTemp : pre) {
            for (int i = 0; i <= listTemp.size(); i++) {
                List<Integer> candidate = new ArrayList<>(listTemp);
                candidate.add(i, nums[index]);
                if (table.add(candidate.toString())) {
                    result.add(candidate);
                }
            }
        }
        return permutation(index + 1, nums, result);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        result.add(new ArrayList<>());
        return permutation(0, nums, result);
    }
}