public class Solution {
    private void rotationPermute (int[] nums, int indexStart, 
        List<Integer> candidateList, List<List<Integer>> resultList) {
        if (candidateList.size() == nums.length) { // no length()
            resultList.add(candidateList);
            return;
        }
        for (int i = 0; i <= candidateList.size(); i++) {
            List<Integer> newCandidateList = new ArrayList<>(candidateList);
            newCandidateList.add(i, nums[indexStart]);
            rotationPermute (nums, indexStart + 1, newCandidateList, resultList);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        else {
            List<List<Integer>> resultList = new ArrayList<>(); // <List<Integer>>
            rotationPermute (nums, 0, new ArrayList<>(), resultList);
            return resultList;
        }
    }
}