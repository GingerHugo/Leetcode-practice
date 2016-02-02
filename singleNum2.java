public class Solution {
    public int singleNumber(int[] nums) {
    	int bitMax = 0;
        for (int i = 0; i < nums.length; i++) {
        	int tempLen = Integer.SIZE-Integer.numberOfLeadingZeros(nums[i]);
        	if (tempLen > bitMax) {
        		bitMax = tempLen;
        	}
        }
        int result = 0;
        for (int i = 0; i < bitMax; i++) {
        	int tempBit = 0;
        	int compareBit = (1 << i);
        	for (int j = 0; j < nums.length; j++) {
        		tempBit += ((nums[j] & compareBit) >> i);
        		// if (nums[j] & compareBit) tempBit += 1;	
        	}
			tempBit = tempBit % 3;
			result |= (tempBit << i);
        }
        return result;
    }
}