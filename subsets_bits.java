public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++)
            result.add(new LinkedList<Integer>());

        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < result.size(); j++)
                if ((j >> i & 1) > 0)
                    result.get(j).add(nums[i]);

        return result;
    }
}