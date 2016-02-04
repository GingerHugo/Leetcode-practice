public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<>();
        if (s.length() < 10) {
            return result;
        }
        Map<String, Integer> table = new HashMap<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            if (!table.containsKey(s.substring(i, i + 10))) {
                table.put(s.substring(i, i + 10), 1);
            }
            else {
                if (table.get(s.substring(i, i + 10)) == 1) {
                    result.add(s.substring(i, i + 10));
                    table.put(s.substring(i, i + 10), 2);
                }
            }
        }
        return result;
    }
}