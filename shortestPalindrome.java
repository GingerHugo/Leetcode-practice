public class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int j = 0;
        for (int i = n - 1; i >= 0; i--)
            if (s.charAt(i) == s.charAt(j)) j++;
        if (j == n) return s;   // To stop the recursive process!!
        return new StringBuffer(s.substring(j)).reverse().toString() + shortestPalindrome(s.substring(0 , j)) + s.substring(j);
    }
}