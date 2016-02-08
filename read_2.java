/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int leftByte = 0;
    private char[] buffer = new char[4];
    public int read(char[] buf, int n) {
        int count = 0;
        boolean endOfFile = false;
        if (leftByte != 0) {
            int length = Math.min(leftByte, n - count);
            for (int i = 0; i < length; i++) {
                buf[i] = buffer[i];
            }
            count += length;
            if (length < leftByte) {
                leftByte = leftByte - length;
                for (int j = 0; j < leftByte; j++) {
                    buffer[j] = buffer[j + length];
                }
                return count;
            }
            else {
                leftByte = 0;
            }
        }
        while (count < n && !endOfFile) {
            int readByte = read4(buffer);
            if (readByte < 4) {
                endOfFile = true;
            }
            int length = Math.min(readByte, n - count);
            for (int i = 0; i < length; i++) {
                buf[count + i] = buffer[i];
            }
            count += length;
            if (length != readByte) {
                leftByte = readByte - length;
                for (int j = 0; j < leftByte; j++) {
                    buffer[j] = buffer[j + length];
                }
            }
        }
        return count;
    }
}