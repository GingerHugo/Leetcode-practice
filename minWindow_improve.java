public class Solution {
    public String minWindow(String s, String t) {
        int[] table = new int[256];
        int count = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i)]++;
        }
        for (int i = 0, j = 0; j < s.length(); j++) {
            table[s.charAt(j)]--;
            if (table[s.charAt(j)] >= 0) {
                count++;
            }
            while (count == t.length()) {
                if (j - i + 1 < minLen) {
                    minStart = i;
                    minLen = j - i + 1;
                }
                table[s.charAt(i)]++;
                if (table[s.charAt(i++)] > 0) {
                    count--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}