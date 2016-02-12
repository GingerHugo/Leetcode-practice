public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> table = new HashMap<>();
        Set<Character> history = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!table.containsKey(s.charAt(i))) {
                if (!history.contains(t.charAt(i))) {
                    table.put(s.charAt(i), t.charAt(i));
                    history.add(t.charAt(i));
                }
                else {
                    return false;
                }
            }
            else if (table.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}