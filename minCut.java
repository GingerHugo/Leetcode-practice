public class Solution {
    public int minCut(String s) {
        int[] result = new int[s.length()];
        boolean[][] table = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 2; i <= s.length(); i++) {
            result[i - 1] = s.length() - 1;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == s.charAt(i - 1) && (i - j < 4 || table[j + 1][i - 1])) 
                    table[j][i] = true;
                else table[j][i] = false;
                if (table[j][i]) {
                    if (j == 0) {
                        result[i - 1] = 0;
                    }
                    else 
                        result[i - 1] = Math.min(result[i - 1], result[j - 1] + 1);
                }
            }
        }
        return result[s.length() - 1];
    }
}