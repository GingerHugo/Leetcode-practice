public class Solution {
    public String shortestPalindrome(String s) {
    	// Too slow and cannot pass the test case
        String revS = new StringBuffer(s).reverse().toString();
        int n = s.length();
        int i = n;
        for (; i > 0; i--)
            if (s.substring(0, i).equals(revS.substring(n - i))) 
                break;
        return i == n ? s : revS.substring(0, n - i) + s;
    }
}