public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int distance = words.length - 1;
        int left = -1;
        int right = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                left = i;
            }
            if (words[i].equals(word2)) {
                right = i;
            }
            if (left != -1 && right != -1) {
                distance = Math.min(distance, Math.max(right, left) - Math.min(right, left));
            }
        }
        return distance;
    }
}