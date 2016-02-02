class TrieNode {
    public TrieNode[] nextNodes = null;
    public boolean isWord;
    // Initialize your data structure here.
    public TrieNode() {
        nextNodes = new TrieNode[26];
        isWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        // word.charAt(i);
        TrieNode rootTemp = root;
        char[] stringArray = word.toCharArray();
        for (int i = 0; i < stringArray.length; i++) {
            if (rootTemp.nextNodes[stringArray[i] - 'a'] == null) {
                rootTemp.nextNodes[stringArray[i] - 'a'] = new TrieNode();
            }
            rootTemp = rootTemp.nextNodes[stringArray[i] - 'a'];
        }
        rootTemp.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode rootTemp = root;
        char[] stringArray = word.toCharArray();
        for (int i = 0; i < stringArray.length; i++) {
            if (rootTemp.nextNodes[stringArray[i] - 'a'] == null) {
                return false;
            }
            rootTemp = rootTemp.nextNodes[stringArray[i] - 'a'];
        }
        return rootTemp.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode rootTemp = root;
        char[] stringArray = prefix.toCharArray();
        for (int i = 0; i < stringArray.length; i++) {
            if (rootTemp.nextNodes[stringArray[i] - 'a'] == null) {
                return false;
            }
            rootTemp = rootTemp.nextNodes[stringArray[i] - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");