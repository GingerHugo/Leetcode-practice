public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null && wordDict == null) {
            return true;
        }
        if (s == null || wordDict == null) {
            return false;
        }
        boolean[] judgeMatrix = new boolean[s.length() + 1];
        judgeMatrix[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (judgeMatrix[j] && wordDict.contains(s.substring(j,i+1))) {
                    judgeMatrix[i+1] = true;
                }
            }
        }
        return judgeMatrix[s.length()]; //Error occurs!
    }
}