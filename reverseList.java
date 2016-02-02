/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pHead = head.next, pre = head;
        pre.next = null;
        while (pHead.next != null) {
            ListNode pTemp = pHead.next;
            pHead.next = pre;
            pre = pHead;
            pHead = pTemp;
        }
        pHead.next = pre;
        return pHead;
    }
}