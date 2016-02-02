public class Solution {
    // Quicker than non-O(N) one.
    private Map<Integer, Integer> table = new HashMap<>();
    private void permutation (List<List<Integer>> result, 
        List<Integer> list, int index, int n) {
        if (n == index) {
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }
        for (int num : table.keySet()) {
            if (table.get(num) != 0) {
                table.put(num, table.get(num) - 1);
                list.add(num);
                permutation(result, list, index + 1, n);
                table.put(num, table.get(num) + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int num : nums) {
            if (!table.containsKey(num)) {
                table.put(num, 0);
            }
            table.put(num, table.get(num) + 1);
        }
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        permutation(result, new ArrayList<>(), 0, nums.length);
        return result;
    }
}