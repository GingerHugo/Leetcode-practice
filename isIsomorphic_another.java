public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[256];
        boolean[] history = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            if (table[s.charAt(i)] == 0) {
                if (!history[t.charAt(i)]) {
                    table[s.charAt(i)] = t.charAt(i);
                    history[t.charAt(i)] = true;
                }
                else {
                    return false;
                }
            }
            else if (table[s.charAt(i)] != (int)t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}