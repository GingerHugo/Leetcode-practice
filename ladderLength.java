public class Solution {
    private int twoEndBFS(Set<String> set1, Set<String> set2, Set<String> dict, int level) {
        dict.removeAll(set1);
        dict.removeAll(set2);
        if (set1.size() > set2.size()) return twoEndBFS(set2, set1, dict, level);
        if (set1.size() == 0) {
            return 0;
        }
        Set<String> set3 = new HashSet<>();
        for (String candidate : set1) {
            char[] cTemp = candidate.toCharArray();
            for (int i = 0; i < cTemp.length; i++) {
                char iChar = cTemp[i];
                for (char jChar = 'a'; jChar <= 'z'; jChar++) {
                    cTemp[i] = jChar;
                    String sTemp = new String(cTemp);
                    if (set2.contains(sTemp)) {
                        return (level + 1);
                    }
                    if (dict.contains(sTemp)) {
                        set3.add(sTemp);
                    }
                }
                cTemp[i] = iChar;
            }
        }
        level++;
        return twoEndBFS(set3, set2, dict, level);
    } 
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);
        int level = 1;
        return twoEndBFS(set1, set2, wordList, level);
    }
}