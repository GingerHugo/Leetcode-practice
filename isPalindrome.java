public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        char[] cArr = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < cArr.length / 2 && i < j; i++, j--) {
            while (!Character.isLetterOrDigit(cArr[i]) && i < j)
                i++;
            while (!Character.isLetterOrDigit(cArr[j]) && i < j)
                j--;
            if (Character.toLowerCase(cArr[i]) != Character.toLowerCase(cArr[j]))
                return false;               
        }
        return true;
    }
}