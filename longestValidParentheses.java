public class Solution {
    public int longestValidParentheses(String s) {
        int left = 0; int max = 0;
        int[] table = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else if (left > 0) {
                int j = i - 1;
                boolean flag = true;
                while(j >= 0) {
                    if (flag && s.charAt(j) == '(') {
                        left--;
                        flag = false;
                        j--;
                    }
                    else if (s.charAt(j) == ')') {
                        if (table[j] != 0) j -= table[j];
                        else break;
                    }
                    else break;
                }
                table[i] = (i - j) / 2 * 2;
                max = Math.max(table[i], max);
            }
        }
        return max;
    }
}