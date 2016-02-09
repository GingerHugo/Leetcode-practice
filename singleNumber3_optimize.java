public class Solution {
    public int[] singleNumber(int[] nums) {
        int count = 0;
        for (int num : nums) {
            count ^= num;
        }

        // Get the bit set
        count &= -count;

        int[] result = new int[2];
        for (int num : nums) {
            if ((count & num) != 0) {
                result[0] ^= num;
            }
            else {
                result[1] ^= num;
            }
        }
        return result;
    }
}