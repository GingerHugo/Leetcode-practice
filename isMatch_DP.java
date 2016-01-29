public class Solution {
    public boolean isMatch(String s, String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++)
            if (p.charAt(i) == '*') count++;
        if (p.length() - count > s.length()) return false;
        // DP begins in the below:
        boolean[][] table = new boolean[p.length() + 1][s.length() + 1];
        table[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            table[i][0] = table[i - 1][0] && p.charAt(i - 1) == '*';
            for (int j = 1; j <= s.length(); j++) {
                if (p.charAt(i - 1) != '*')
                    table[i][j] = table[i - 1][j - 1] && (p.charAt(i - 1) == '?' ||
                    p.charAt(i - 1) == s.charAt(j - 1));
                else {
                    table[i][j] = table[i - 1][j] || table[i][j - 1];
                    // If condition means that if p[j-1] is not *, 
                    //    f(i,j) is determined by if s[0:i-2] matches p[0:j-2] 
                    //    and if (s[i-1]==p[j-1] or p[j-1]=='?').
                    // Else condition means that if p[j-1] is *, 
                    //    f(i,j) is true if either f(i,j-1) is true: 
                    //    1. s[0:i-1] matches p[0:j-2] and * is not used here; 
                    //    2. or f(i-1,j) is true: s[0:i-2] matches p[0:j-1] and * is used to match s[i-1].
                }
            }
        }
        return table[p.length()][s.length()];
    }
}