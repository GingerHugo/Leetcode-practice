/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>("size", Collections.reverseOrder());
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                if (a.val < b.val) {
                    return -1;
                }
                else if (a.val == b.val) {
                    return 0;
                }
                else {
                    return 1;
                }
            } 
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (!queue.isEmpty()) {
            pre.next = queue.poll();
            pre = pre.next;
            if (pre.next != null) {
                queue.add(pre.next);
            }
        }
        return head.next;
    }
}