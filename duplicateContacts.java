public class Solution {
    private void drawGraph(int[][] matrix, List<List<String>> contacts) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<String> temp1 = contacts.get(i);
                List<String> temp2 = contacts.get(j);
                boolean flag = true;
                for (k = 0; k < m && flag; k++) {
                    for (l = 0; l < m; l++) {
                        if (temp1.get(k).equals(temp2.get(l))) {
                            flag = false;
                            matrix[i][j] = 1;
                            break;
                        }
                    }
                }
            }
        }
    }

    private void DFS(List<String> candidate, int[][] matrix, int index, Set<Integer> visited) {
        visited.add(index);
        candidate.add(index);
        for (i = index + 1; i < matrix.length; i++) {
            if (matrix[index][i] == 1 && !visited.contains(i)) {
                DFS(candidate, matrix, i, visited);
            }
        }
    }

    public List<List<Integer>> duplicateContacts(List<List<String>> contacts) {
        List<List<Integer>> result = new LinkedList<>();
        if (contacts == null) {
            return result;
        }
        int n = contacts.size();
        int m = contacts.get(0).size();
        int[][] matrix = new int[n][n];
        drawGraph(matrix, contacts);
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                List<String> candidate = new LinkedList<>();
                DFS(candidate, matrix, i, visited);
                result.add(candidate);
            }
        }
        return result;
    }
}