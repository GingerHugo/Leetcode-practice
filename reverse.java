public class Solution {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {    // Negative Number
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;   // Handle overflow
            x /= 10;
        }
        return (int)result;
    }
}