public class Solution {
    public int climbStairs(int n) {
        if (n <= 3) {
        	return n;
        }
        int firstTemp = 2;
        int secondTemp = 3;
        int result = 0;
        for (int i = 3; i < n; i++) {
            result = firstTemp + secondTemp;
            firstTemp = secondTemp;
            secondTemp = result;
        }
        return result;
    }
}