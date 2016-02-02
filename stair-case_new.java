public class Solution {
    private int iCount = 0;
    public int climbStairs(int n) {
        if (n <= 3) {
        	return n;
        }
        Stack stCount = new Stack();
        stCount.push(n);
        while(!stCount.empty()) {
            int numTemp = (Integer)stCount.pop();
            if (numTemp > 3) {
                stCount.push(n - 2);
                stCount.push(n - 1);
            }
            else {
                iCount += numTemp;
            }
        }
        return iCount;
    }
}