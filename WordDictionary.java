public class WordDictionary {
    private Map<Integer, List<String>> wordSet;
    private Set<String> wordHashSet;
    public WordDictionary () {
        wordSet = new HashMap<Integer, List<String>>();
        wordHashSet = new HashSet<String>();
    }

    private boolean isSame (String candidate, String word) {
        for (int i = 0; i < word.length(); i++) {
            if ((word.charAt(i) != '.') && (word.charAt(i) != candidate.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        int wordLength = word.length();
        wordHashSet.add(word);
        if (wordSet.containsKey(Integer.valueOf(wordLength))) {
            wordSet.get(wordLength).add(word);
        }
        else {
            List<String> listTemp = new ArrayList<String>();
            listTemp.add(word);
            wordSet.put(wordLength, listTemp);
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (wordHashSet.contains(word)) {
            return true;
        }
        int wordLength = word.length();
        if (wordSet.containsKey(Integer.valueOf(wordLength))) {
            List<String> listTemp = wordSet.get(wordLength);
            for (String s: listTemp) {
                if (isSame(s, word)) {
                    return true;
                }
            }
            return false;
        }
        else {
            return false;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
// String[] b = a.split("\\.");