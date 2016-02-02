public class Solution {
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (nums.length == 0 || nums == null) {
        return res;
    }
    Arrays.sort(nums);
    for (int count = 0; count <= nums.length; count++) {
        search(count, 0, nums, new ArrayList<Integer>(), res);
    }
    return res;
}
public void search(int count, int start, int[] nums, List<Integer> temp, List<List<Integer>> res) {
    if (temp.size() == count) {
        res.add(temp);
        return;
    }
    for (int i = start; i < nums.length; i++) {
        List<Integer> newTemp = new ArrayList<Integer>(temp);
        newTemp.add(nums[i]);
        search(count, i + 1, nums, newTemp, res);
    }
}