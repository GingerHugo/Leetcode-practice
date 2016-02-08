/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int count = 0;
        boolean endOfFile = false;
        while (count < n && !endOfFile) {
            int result = read4(buffer);
            if (result < 4) {
                endOfFile = true;
            }
            int m = Math.min(n - count, result);
            for (int i = 0; i < m; i++) {
                buf[count + i] = buffer[i];     
            }
            count += m;
        }
        return count;
    }
}