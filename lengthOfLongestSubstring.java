public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> already = new HashMap<>();
        int length = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (already.containsKey(s.charAt(i))) {
                int temp2 = i - already.get(s.charAt(i));
                already.put(s.charAt(i), i);
                if (temp2 > temp) length = Math.max(length, ++temp);
                else temp = temp2;
            }
            else {
                already.put(s.charAt(i), i);
                length = Math.max(length, ++temp);
            }
        }
        return length;
    }
}