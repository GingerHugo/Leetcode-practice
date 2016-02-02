public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n < 2) return true;
        if (edges.length < n - 1) return false;
        Map<Integer, List<Integer>> table = new HashMap<>();
        for (int[] pair : edges) {
            if (!table.containsKey(pair[0])) {
                table.put(pair[0], new LinkedList<Integer>());
            }
            if (!table.containsKey(pair[1])) {
                table.put(pair[1], new LinkedList<Integer>());
            }
            table.get(pair[0]).add(pair[1]);
            table.get(pair[1]).add(pair[0]);
        }
        Set<Integer> history = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> parentQueue = new LinkedList<Integer>();
        queue.offer(edges[0][0]);
        parentQueue.offer(-1);
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            int parent = parentQueue.poll();
            history.add(temp);
            for (int node : table.get(temp)) {
                if (node != parent) {
                    if (history.contains(node)) {
                        return false;
                    }
                    queue.offer(node);
                    parentQueue.offer(temp); 
                }
            }
        }
        return history.size() == n ? true : false;
    }
}