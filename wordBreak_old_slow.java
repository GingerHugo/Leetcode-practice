public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null && wordDict == null) {
            return true;
        }
        if (s == null || wordDict == null) {
            return false;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0, i))) {
                if (i == s.length()) {
                    return true;
                }
                else if (wordBreak(s.substring(i), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }
}