public class Solution {
    private HashMap<String, Boolean> palindromeTable = new HashMap<>();
    public int minCut(String s) {
        int[] result = new int[s.length()];
        for (int i = 2; i <= s.length(); i++) {
            result[i - 1] = s.length() - 1;
            for (int j = 0; j < i; j++) {
                boolean flag;
                int n = i - j;
                if (s.charAt(j) != s.charAt(i - 1)) flag = false;
                else if (n < 4) flag = true;
                else flag = palindromeTable.get(s.substring(j + 1, i - 1));
                palindromeTable.put(s.substring(j, i), flag);
                if (flag) {
                    if (j == 0) {
                        result[i - 1] = 0;
                        // break;
                    }
                    else 
                        result[i - 1] = Math.min(result[i - 1], result[j - 1] + 1);
                }
            }
        }
        return result[s.length() - 1];
    }
}