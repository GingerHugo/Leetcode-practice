public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (Math.abs(m - n) > 1) return false;
        int k = Math.min(m, n);
        int i = 0, j = 0;
        while (i < k && s.charAt(i) == t.charAt(i)) i++;
        while (j < k - i && 
            s.charAt(m - 1 - j) == t.charAt(n - 1 - j)) j++;
        return i + j + 1 == Math.max(m, n) ? true : false;
    }
}