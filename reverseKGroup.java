/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        boolean flag = true;
        ListNode preNode = null;
        ListNode nexNode = head;
        ListNode tail = head;
        ListNode tempHead = tail;

        while (nexNode != null) {
            int count = k;
            while (count > 0) {
                if (nexNode == null) {
                    flag = false;
                    break;
                }
                ListNode temp = nexNode.next;
                nexNode.next = preNode;
                preNode = nexNode;
                nexNode = temp;
                count--;
            }
            if (!flag) {
                // Reverse back
                while (nexNode != tempHead) {
                    ListNode temp = preNode.next;
                    preNode.next = nexNode;
                    nexNode = preNode;
                    preNode = temp;
                }
                return head;
            }
            if (tail == head) {
                head = preNode;
            }
            else {
                tail.next = preNode;
                tail = tempHead;    
            }
            tail.next = nexNode;
            tempHead = tail.next;
        }
        return head;
    }
}