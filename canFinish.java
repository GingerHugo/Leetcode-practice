public class Solution {
    private HashMap<Integer, Boolean> historyMap = new HashMap<>(); // For no dupilcate works
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> mapGraph = new HashMap<Integer, HashSet<Integer>>();
        for (int[] i: prerequisites) {
            if (!mapGraph.containsKey(Integer.valueOf(i[0]))) {
                mapGraph.put(Integer.valueOf(i[0]), new HashSet<Integer>());             
            }
            mapGraph.get(Integer.valueOf(i[0])).add(Integer.valueOf(i[1]));
        }
        HashSet<Integer> pathRecord = new HashSet<>();
        // for (Map.Entry<Integer, HashSet<Integer>> entry: mapGraph.entrySet()) {
        for (int[] i: prerequisites) {
            if (hasCycle(mapGraph, i[0], pathRecord)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(HashMap<Integer, HashSet<Integer>> mapGraph, Integer start, HashSet<Integer> pathRecord) {
        if (historyMap.containsKey(start)) return historyMap.get(start);
        if (pathRecord.contains(start)) return true;
        if (!mapGraph.containsKey(start)) return false;
        pathRecord.add(start);
        for (Integer kid: mapGraph.get(start)) {
            boolean result = hasCycle(mapGraph, kid, pathRecord);
            if (result) {
                return true;
            }
            historyMap.put(kid, result);
        }
        pathRecord.remove(start);
        return false;
    }
}