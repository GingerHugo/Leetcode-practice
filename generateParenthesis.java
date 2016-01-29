public class Solution {
    private void backTrackString (List<String> resultList, String tempString, int left, int right) {
        if ((left == 0) && (right == 0)) {
            resultList.add(tempString);
            return;
        }
        if (left > 0) {
            backTrackString (resultList, tempString + '(', left - 1, right);
        }
        if (left < right) {
            backTrackString (resultList, tempString + ')', left, right - 1);
        }
        return;
    }

    public List<String> generateParenthesis(int n) {
        List<String> resultList;
        if (n == 0) {
            resultList = null;
        }
        else if (n == 1) {
            resultList = new LinkedList<String>();
            resultList.add("()");
        }
        else {
            // List<String> resultTempList = generateParenthesis(n - 1);
            resultList = new LinkedList<String>();
            // for (String candidateString : resultTempList) {
            //     resultList.add(String.format("(%s)", candidateString));
            //     String oneTemp = String.format("()%s", candidateString);
            //     String twoTemp = String.format("%s()", candidateString);
            //     if (oneTemp.equals(twoTemp)) {
            //         resultList.add(oneTemp);
            //     }
            //     else {
            //         resultList.add(oneTemp);
            //         resultList.add(twoTemp);
            //     }
            // }
            backTrackString (resultList, "", n, n);
        }
        return resultList;
    }
}