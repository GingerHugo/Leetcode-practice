/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = read4(buf);
        int result = n;
        while (count == 4) {
            result -= 4;
            count = read4(buf);
        }
        result -= count;
        return Math.min(n, n - result);
    }
}