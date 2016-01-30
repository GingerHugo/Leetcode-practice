public class Solution {
    private Map<String, Integer> table = new HashMap<>();
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) > '9' || s.charAt(0) < '1') return 0;
        int count = 0;
        int temp = 0;
        if (table.containsKey(s.substring(1)))
            count += table.get(s.substring(1));
        else {
            if (s.length() > 1) {
                temp = numDecodings(s.substring(1));
                table.put(s.substring(1), temp);
            }
            else temp = 1;
            count += temp;
        }
        if (s.length() > 1 && Integer.parseInt(s.substring(0, 2)) <= 26) {
            if (table.containsKey(s.substring(2)))
            count += table.get(s.substring(2));
            else {
                if (s.length() > 2) {
                    temp = numDecodings(s.substring(2));
                    table.put(s.substring(2), temp);
                }
                else temp = 1;
                count += temp;
            }
        }
        return count;
    }
}