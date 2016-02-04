public class Solution {
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (s.charAt(i) == ')' && count-- == 0) {
                return false;
            }
        }
        return count == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        // BFS
        List<String> result = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> table = new HashSet<>();
        queue.offer(s);
        table.add(s);
        boolean flag = false;
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            if (isValid(temp)) {
                flag = true;
                result.add(temp);
            }
            if (flag) {
                continue;
            }
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) != '(' && temp.charAt(i) != ')') {
                    continue;
                }
                String newOne = temp.substring(0, i) + temp.substring(i + 1, temp.length());
                if (!table.contains(newOne)) {
                    table.add(newOne);
                    queue.offer(newOne);
                }
            }
        }
        return result;
    }
}