public class Solution {
    private int oneEndBFS(Queue<String> queue, String endWord, Set<String> dict, int level) {
        while(!queue.isEmpty()) {
            int iSize = queue.size();
            for (int k = 0; k < iSize; k++) {
                String word = queue.poll();
                char[] cTemp = word.toCharArray();
                for (int i = 0; i < cTemp.length; i++) {
                    char iChar = cTemp[i];
                    for (char jChar = 'a'; jChar <= 'z'; jChar++) {
                        cTemp[i] = jChar;
                        String sTemp = new String(cTemp);
                        if (endWord.equals(sTemp)) {
                            return (level + 1);
                        }
                        if (dict.contains(sTemp)) {
                            queue.offer(sTemp);
                            dict.remove(sTemp);
                        }
                    }
                    cTemp[i] = iChar;
                }
            }
            level++; 
        }
        return 0;
    } 
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        return oneEndBFS(queue, endWord, wordList, level);
    }
}