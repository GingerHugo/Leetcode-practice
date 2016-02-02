public class Solution {
    private List<String> result = null;
    private void judgeWord(String s, Set<String> wordDict, StringBuilder element, int start) {
        if (start == s.length()) {
            result.add(element.toString());
            // return true;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))) {
                if(start != 0) element.append(" ");    //StringBuilder append not add
                element.append(s.substring(start, i));
                judgeWord(s, wordDict, element, i);
                if(start != 0) element.setLength(element.length() - (i - start + 1));
                else element.setLength(element.length() - (i - start));
            }
        }
        // return false;
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        result = new LinkedList<>();
        StringBuilder element = new StringBuilder();
        judgeWord(s, wordDict, element, 0);
        return result;
    }
}