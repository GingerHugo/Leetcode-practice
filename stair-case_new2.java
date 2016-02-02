public class Solution {
    private int iCount = 0;
    public int climbStairs(int n) {
        if (n <= 3) {
        	return n;
        }
        List<Integer> stCount = new ArrayList<Integer>(2 * n);
        stCount.add(0,n);
        while(!stCount.isEmpty()) {
            int numTemp = stCount.get(0);
            stCount.remove(0);
            if (numTemp > 3) {
                stCount.add(0,n - 2);
                stCount.add(0,n - 1);
            }
            else {
                iCount += numTemp;
            }
        }
        return iCount;
    }
}