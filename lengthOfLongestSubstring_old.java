public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> already = new HashSet<>();
        int length = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (already.contains(s.charAt(i))) {
                already.clear();
                already.add(s.charAt(i));
                temp = 1;
            }
            else {
                already.add(s.charAt(i));
                length = Math.max(++temp, length);
            }
        }
        return length;
    }
}