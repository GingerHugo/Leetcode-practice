/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode first = head;
        ListNode last = head;
        while(last.next != null && last.next.next != null) {
            first = first.next;
            last = last.next.next;
        }

        // Reverse the candidate list
        ListNode reverseNode = first.next;
        ListNode previousNode = null;
        while (reverseNode.next != null) {
            ListNode temp = reverseNode.next;
            reverseNode.next = previousNode;
            previousNode = reverseNode;
            reverseNode = temp;
        }
        reverseNode.next = previousNode;
        

        // Reorder the list
        first.next = null;
        last = reverseNode;
        first = head;
        while (last != null) {
            ListNode temp = first.next;
            // previousNode = first;
            first.next = last;
            first = temp;
            temp = last.next;
            last.next = first;
            last = temp;
        }
        // first.next = null;
        return;
    }
}