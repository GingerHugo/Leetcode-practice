public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) > '9' || s.charAt(0) < '1') return 0;
        int pre1 = 1;
        int pre2 = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '1')
                pre1 = 0;
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) < '7') {
                pre1 = pre1 + pre2;
                pre2 = pre1 - pre2;
            }
            else
                pre2 = pre1;
        }
        return pre1;
    }
}