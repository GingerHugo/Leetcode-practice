/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> table = new HashMap<>();
        Queue<UndirectedGraphNode> candidate = new LinkedList<>();
        Queue<UndirectedGraphNode> element = new LinkedList<>();
        candidate.offer(node);
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        element.offer(head);
        table.put(head.label, head);
        while (!candidate.isEmpty()) {
            UndirectedGraphNode temp = candidate.poll();
            UndirectedGraphNode eleN = element.poll();
            for (UndirectedGraphNode n : temp.neighbors) {
                if (!table.containsKey(n.label)) {
                    UndirectedGraphNode neighbor = new UndirectedGraphNode(n.label);
                    table.put(n.label, neighbor);
                    candidate.offer(n);
                    element.offer(neighbor);
                }
                eleN.neighbors.add(table.get(n.label));
            }
        }
        return head;
    }
}