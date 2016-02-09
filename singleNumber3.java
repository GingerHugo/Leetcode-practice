public class Solution {
    public int[] singleNumber(int[] nums) {
        int count = 0;
        for (int num : nums) {
            count ^= num;
        }
        int bit = 0;
        for (; bit < 32; bit++) {
            if ((1 << bit & count) != 0) {
                break;
            }
        }
        int[] result = new int[2];
        for (int num : nums) {
            if ((1 << bit & num) != 0) {
                result[0] ^= num;
            }
            else {
                result[1] ^= num;
            }
        }
        return result;
    }
}