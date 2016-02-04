public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> table = new HashMap<>();
        int[] inLink = new int[numCourses];
        for (int[] pair : prerequisites) {
            if (!table.containsKey(pair[1])) {
                table.put(pair[1], new LinkedList<Integer>());
            }
            table.get(pair[1]).add(pair[0]);
            inLink[pair[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inLink[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[count++] = node;
            if (table.containsKey(node)) {
                for (int temp : table.get(node)) {
                    if(--inLink[temp] == 0) {
                        queue.offer(temp);
                    }
                }
            }
        }
        return count == numCourses ? result : new int[0];
    }
}