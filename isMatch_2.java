public class Solution {
    private char[] sArr;
    private char[] pArr;
    private boolean isMatchIndex(int i, int j) {
        if (j == pArr.length) {
            return i == sArr.length;
        }
        if (j != pArr.length - 1 && pArr[j + 1] == '*') {
            return (i < sArr.length && (pArr[j] == sArr[i] || pArr[j] == '.') && isMatchIndex(i + 1, j)) 
            || isMatchIndex(i, j + 2);
        }
        else {
            if (i == sArr.length) {
                return false;
            }
            return (pArr[j] == '.' || sArr[i] == pArr[j]) && isMatchIndex(i + 1, j + 1);
        }
    }
    public boolean isMatch(String s, String p) {
        sArr = s.toCharArray();
        pArr = p.toCharArray();
        return isMatchIndex(0, 0);
    }
}