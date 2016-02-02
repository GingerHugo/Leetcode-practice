public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int left = -1;
        int right = -1;
        int len = words.length - 1;
        boolean flag = word1.equals(word2) ? true : false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (flag) {
                    right = left;
                }
                left = i;
            }
            else if (words[i].equals(word2)) {
                right = i;
            }
            if (left != -1 && right != -1) {
                len = Math.min(len, Math.abs(left - right));
            }
        }
        return len;
    }
}