public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int MAXIMUN = 32;
        int left = 0;
        for (int i = 0; i < MAXIMUN; i++) {
            if (((m >> i) == 0) && (left == 0)) {
                left = i;
                break;
            }
        }
        if (n >> left != 0) {
            return 0;
        }
        else {
            int finalNum = 0;
            for (int i = left - 1; i >= 0; i--) {
                if ((m >> i) != (n >> i)) {
                    finalNum = i + 1;
                    break;
                }
            }
            int result = 2147483647 << finalNum;
            result = result & m;
            return result;
        }
    }
}