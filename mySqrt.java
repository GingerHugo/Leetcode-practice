public class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 0, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) return mid;
            else if (mid > x / mid) right = mid;
            else left = mid + 1;
        }
        return left - 1; 
        // At last left == right, 
        // and left the is least number that is larger than sqrt 
    }
}