public class Solution {
    private void addBlank(StringBuilder sbTemp, int blankLength) {
        for (int i = 0; i < blankLength; i++)
            sbTemp.append(" ");
    }

    private void processJustify(int counter, List<String> lsTemp, List<String> result, int maxWidth) {
        StringBuilder sbTemp = new StringBuilder();
        if (lsTemp.size() == 0) return;
        else if (lsTemp.size() == 1) {
            if (counter != 0)
                sbTemp.append(lsTemp.get(0));
            else
                sbTemp.append("");
            addBlank(sbTemp, maxWidth - counter);
            result.add(sbTemp.toString()); return;
        }
        int blankLength = maxWidth - counter;
        int gap = lsTemp.size() - 1;
        int rightGap = blankLength / gap;
        int leftGap = blankLength % gap == 0 ? rightGap : rightGap + 1;
        int leftNum = (leftGap == rightGap ? blankLength : (blankLength - gap * rightGap) / (leftGap - rightGap));
        for (int i = 0; i < lsTemp.size(); i++) {
            sbTemp.append(lsTemp.get(i));
            if (i == lsTemp.size() - 1) continue;
            if (leftNum != 0) {
                addBlank(sbTemp, leftGap); leftNum--;
            }
            else
                addBlank(sbTemp, rightGap);
        }
        result.add(sbTemp.toString()); return;
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int counter = 0;
        List<String> lsTemp = new LinkedList<>();
        List<String> result = new LinkedList<>();
        for (String word : words) {
            if (counter + word.length() < maxWidth) {
                lsTemp.add(word);
                counter += word.length();
            }
            else {
                processJustify(counter, lsTemp, result, maxWidth);
                lsTemp.clear();
                lsTemp.add(word);
                counter = word.length();
            }
        }
        processJustify(counter, lsTemp, result, maxWidth);
        return result;
    }
}