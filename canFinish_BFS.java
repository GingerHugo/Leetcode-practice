public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) {
            return true;
        }

        HashMap<Integer, HashSet<Integer>> mapGraph = new HashMap<Integer, HashSet<Integer>>();
        int[] inLink = new int[numCourses];
        for (int[] i: prerequisites) {
            if (!mapGraph.containsKey(i[1])) {
                mapGraph.put((i[1]), new HashSet<Integer>());             
            }
            if (!mapGraph.get(i[1]).contains(i[0])) {
                inLink[i[0]]++; // The node pair may be depilcate!
            }
            mapGraph.get(i[1]).add(i[0]);   
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inLink[i] == 0) {
                queue.add(i);
            }
        }

        int countTemp = queue.size();
        while(!queue.isEmpty()) {
            int solvedPre = queue.remove();
            if (mapGraph.containsKey(solvedPre)) {
                for (int i: mapGraph.get(solvedPre)) {
                    inLink[i]--;
                    if (inLink[i] == 0) {
                        countTemp++;
                        queue.add(i);
                    }
                }
            }
        }
        return (countTemp == numCourses);
    }
}