public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        if (s.charAt(0) == s.charAt(s.length() - 1))
            return isPalindrome(s.substring(1, s.length() - 1));
        else if (s.charAt(0) > '9' || s.charAt(0) < '0' || s.charAt(0) > 'z' || s.charAt(0) < 'a')
            return isPalindrome(s.substring(1, s.length() - 1));
        else if (s.charAt(s.length() - 1) > '9' || s.charAt(s.length() - 1) < '0' 
            || s.charAt(s.length() - 1) > 'z' || s.charAt(s.length() - 1) < 'a')
            return isPalindrome(s.substring(1, s.length() - 1));
        else
            return false;
    }
}