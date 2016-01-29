public class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length();) {
            if (s.length() - i <= maxLen / 2) break;
            int j = i;
            int k = i;
            while (k < s.length() - 1 && s.charAt(k) == s.charAt(k + 1)) k++;
            i = k + 1;
            while (k < s.length() - 1 && j > 0 && s.charAt(k + 1) == s.charAt(j - 1)) {
                k++;
                j--;
            }
            int tempLen = k - j + 1;
            if (tempLen > maxLen) {
                maxLen = tempLen;
                startIndex = j;
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }
}