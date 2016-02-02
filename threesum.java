public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
        	return resultList;
        }
        int sumNum = 0;
        for (int i = 0; i < nums.length; i++) {
        	if((i > 0) && (nums[i] == nums[i - 1])) continue;
        	int goalNum = sumNum - nums[i];
        	int indexLeft = i + 1;
        	int indexRight = nums.length - 1;
        	while (indexLeft < indexRight) {
        		if (nums[indexLeft] + nums[indexRight] == goalNum) {
        			List<Integer> tempList = new ArrayList();
        			tempList.add(nums[i]);
        			tempList.add(nums[indexLeft]);
        			tempList.add(nums[indexRight]);
        			resultList.add(tempList);
        			while((indexLeft < indexRight) && (nums[indexLeft] == nums[indexLeft + 1])) indexLeft++;
        			while((indexLeft < indexRight) && (nums[indexRight] == nums[indexRight - 1])) indexRight--;
        		}
        		else if (nums[indexLeft] + nums[indexRight] > goalNum) {
        			indexRight--;
        			continue;
        		}
        		else {
        			indexLeft++;
        			continue;
        		}
        		if (indexLeft < indexRight) {
        			indexLeft++;
        			indexRight--;
        		}
        	} 
        }
        return resultList;
    }
}