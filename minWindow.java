public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> table = new HashMap<>();
        Map<Character, Integer> letters = new HashMap<>();
        String result = "";
        for (int i = 0; i < t.length(); i++) {
            if (!letters.containsKey(t.charAt(i))) {
                letters.put(t.charAt(i), 0);
            }
            letters.put(t.charAt(i), letters.get(t.charAt(i)) + 1);
        }
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (!table.containsKey(s.charAt(i))) {
                table.put(s.charAt(i), 0);
            }
            table.put(s.charAt(i), table.get(s.charAt(i)) + 1);
            boolean flag = true;
            while (true) {
                if (j > i) {
                    break;
                }
                for (Map.Entry<Character, Integer> letter : letters.entrySet()) {
                    if (!table.containsKey(letter.getKey()) || table.get(letter.getKey()) < letter.getValue()) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
                if (result.length() == 0 || (i + 1 - j) < result.length()) {
                    result = s.substring(j, i + 1);
                }
                table.put(s.charAt(j), table.get(s.charAt(j++)) - 1);
            }
        }
        return result;
    }
}