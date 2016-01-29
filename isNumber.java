public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();   // Delete blank in the two sides
        boolean numSeen, numAfterE, eSeen, dotSeen;
        numAfterE = true;
        numSeen = eSeen = dotSeen = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numSeen = true;
                numAfterE = true;
            }
            else if (s.charAt(i) == '.') {
                if (!dotSeen && !eSeen) dotSeen = true;
                else return false;
            }
            else if (s.charAt(i) == 'e') {
                if (!eSeen && numSeen) {
                    numAfterE = false;
                    eSeen = true;
                }
                else return false;
            }
            else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            }
            else return false;
        }
        return numAfterE && numSeen;
    }
}