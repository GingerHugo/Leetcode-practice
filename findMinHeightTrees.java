public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new HashSet<>()); // Initialization
        // for (int i = 0; i < n; i++) graph.get(i) = new HashSet<>(); // Initialization, wrong
        for (int[] pair : edges) {
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            if (graph.get(i).size() == 1) leaves.add(i);
        
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int node : leaves) {
                int j = graph.get(node).iterator().next();          // Get only element from set
                graph.get(j).remove(node);
                if (graph.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}