public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || 
            dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean flag = true;
        long a = Math.abs((long)dividend);
        if (a != dividend) flag = !flag;
        long b = Math.abs((long)divisor);
        if (b != divisor) flag = !flag;
        int result = 0;
        while (a >= b) {
            int count = 0;
            long temp = a - b;
            while (temp >= 0) {
                temp = a - (b << ++count); 
            }
            a -= (b << --count);
            result += (1 << count);
        }
        return flag ? result : -result;
    }
}