public class Solution {
    private Map<Character, Integer> innerTable = new HashMap<>();
    private int maxiMun;
    private void initialize() {
        innerTable.put('A', 0);
        innerTable.put('T', 1);
        innerTable.put('C', 2);
        innerTable.put('G', 3);
        maxiMun = 0xFFFFF;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<Integer> table = new HashSet<>();
        initialize();
        int key = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = innerTable.get(s.charAt(i));
            if (i < 9) {
                key = key << 2 | temp;
            }
            else {
                key = (key << 2 & maxiMun) | temp;
                if (!table.contains(key)) {
                    table.add(key);
                }
                else {
                    result.add(s.substring(i - 9, i + 1));
                }
            }
        }
        return new ArrayList<>(result);
    }
}