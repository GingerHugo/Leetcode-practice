/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if ((head != null) && (head.next != null)) {
            int numTemp = 0;
            ListNode nodeNext = head;
            head = head.next;
            ListNode nodePrew = null;
            ListNode nodeTemp = null;
            while (nodeNext != null) {
                if (numTemp == 1) {
                    nodePrew.next = nodeNext.next;
                    nodeNext.next = nodePrew;
                    nodeNext = nodePrew.next;
                }
                else if ((numTemp % 2) == 1) {
                    nodeTemp.next = nodeNext.next;
                    nodeNext.next = nodeTemp;
                    nodePrew.next = nodeNext;
                    nodePrew = nodeTemp;
                    nodeNext = nodeTemp.next;
                }
                else if (numTemp != 0) {
                    nodeTemp = nodeNext;
                    nodeNext = nodeNext.next;
                }
                else {
                    nodePrew = nodeNext;
                    nodeNext = nodeNext.next;
                }
                numTemp += 1;
            }
        }
        return head;
    }
}