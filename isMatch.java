public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int start = -1;
        int sRecord = -1;
        while (i < s.length()) {    // Unlike C++ has a '\0' ending, Java need to consider the ending case
            if (j < p.length()) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    i++; j++; continue;
                }
                if (p.charAt(j) == '*') {
                    start = j++; sRecord = i; continue;
                }
            }
            if (start >= 0) {
                j = start + 1; i = ++sRecord; continue; 
            }
            return false;
        }
        while (j < p.length() && p.charAt(j) == '*') j++;
        return j == p.length() ? true : false;
    }
}