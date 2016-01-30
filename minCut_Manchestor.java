// Manancher-like solution
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] result = new int[n + 1];  // Must be n+1 to cover the (0,n) case
        char[] cArray = s.toCharArray();
        for (int i = 0; i <= n; i++) result[i] = i - 1; // first i element, maximun possible partition
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i && i + j < n && cArray[i + j] == cArray[i - j]; j++)
                result[i + j + 1] = Math.min(result[i + j + 1], result[i - j] + 1);
            for (int j = 0; j <= i - 1 && i + j < n && cArray[i + j] == cArray[i - j - 1]; j++)
                result[i + j + 1] = Math.min(result[i + j + 1], result[i - j - 1] + 1);
        }
        return result[n];
    }
}