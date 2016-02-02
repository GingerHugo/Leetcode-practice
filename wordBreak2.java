public class Solution {
    private List<String> result = null;
    private boolean earlyStop(String s, Set<String> wordDict) {
        for (int i = s.length() - 1; i >= 0; i--)
            if (wordDict.contains(s.substring(i))) return false;
        return true;
    }
    private void judgeWord(String s, Set<String> wordDict, StringBuilder element, int start) {
        if (s.length() == 0) {
            result.add(element.toString());
        }
        for (int i = 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0, i))) {
                if(start != 0) element.append(" ");    //StringBuilder append not add
                element.append(s.substring(0, i));
                // System.out.println(s.substring(i));
                judgeWord(s.substring(i), wordDict, element, 1);
                if(start != 0) element.setLength(element.length() - (i + 1));
                else element.setLength(element.length() - i);
            }
        }
        // return false;
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        result = new LinkedList<>();
        StringBuilder element = new StringBuilder();
        if(!earlyStop(s, wordDict)) judgeWord(s, wordDict, element, 0);
        return result;
    }
}