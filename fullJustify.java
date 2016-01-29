public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) { 
        List<String> result = new LinkedList<>();
        for (int i = 0, k, l; i < words.length; i += k) {
            for (k = l = 0; i + k < words.length && 
                l + words[i + k].length() <= maxWidth - k; k++)
                l += words[i + k].length();
            StringBuilder sbTemp = new StringBuilder(words[i]);
            for (int j = 0; j < k - 1; j++) {
                if (i + k == words.length) sbTemp.append(" ");
                else {
                    int number = (maxWidth - l) / (k - 1) + (j < ((maxWidth - l) % (k - 1)) ? 1 : 0);
                    sbTemp.append(String.format("%"+number+"s", ""));
                }
                sbTemp.append(words[i + j + 1]);
            }
            int count = maxWidth - sbTemp.length();     // Count cannot be zero!!
            if (count > 0) sbTemp.append(String.format("%"+count+"s", ""));
            // Another way of output blank
            // char[] spaceGaps = new char[10];
            // Arrays.fill(spaceGaps, ' ');
            // String result2 = String.valueOf(spaceGaps);
            // String result2 = spaceGaps.toString();
            result.add(sbTemp.toString());
        }
        return result;
    }
}