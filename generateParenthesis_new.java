public class Solution {
    private void backTrackDFS(List<String> result, String s, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left < right) {
            if (left > 0) {
                backTrackDFS(result, s + "(", left - 1, right);
            }
            backTrackDFS(result, s + ")", left, right - 1);
        }
        else {
            backTrackDFS(result, s + "(", left - 1, right);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backTrackDFS(result, "", n, n);
        return result;
    }
}