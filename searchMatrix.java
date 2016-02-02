public class Solution {

}    private boolean searchLine(int[] line, int target) {
        int left = 0;
        int right = line.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (line[mid] == target) return true;
            else if (line[mid] > target) right = mid;
            else left = mid + 1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) break;
            if (searchLine(matrix[i], target)) return true;
        }
        return false;
        // int left = 0;
        // int right = matrix.length;
        // int mid = (left + right) / 2;
        // List<Integer> queue = new LinkedList<>();
        // queue.add(mid);
        // while (!queue.isEmpty()) {
            
        //     if (matrix[mid][0] > target) {
        //         right = mid;
        //         continue;
        //     }
        //     else if (searchLine(matrix[mid], target)) return true; 
        //     else {   
        //     }} 
        // }
    }