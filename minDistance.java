public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] table = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) 
            table[i][0] = i;
        for (int i = 0; i <= word2.length(); i++) 
            table[0][i] = i;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) //Index range
                    table[i][j] = table[i - 1][j - 1];
                else {
                    // Compare replace and deletion
                    table[i][j] = Math.min(table[i - 1][j - 1] + 1, table[i - 1][j] + 1);
                    // Compare with insertion
                    table[i][j] = Math.min(table[i][j], table[i][j - 1] + 1);
                }
            }
        }
        return table[word1.length()][word2.length()];
    }
}