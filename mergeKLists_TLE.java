/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode mergeTwoList(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        ListNode head = first;
        if (first.val < second.val) {
            first = first.next;
        }
        else {
            head = second;
            second = second.next;
        }
        ListNode pre = head;
        while (first != null || second != null) {
            if (first != null && second != null) {
                if (first.val < second.val) {
                    pre.next = first;
                    first = first.next;
                }
                else {
                    pre.next = second;
                    second = second.next;
                }
            }
            else if (first != null) {
                pre.next = first;
                first = first.next;
            }
            else {
                pre.next = second;
                second = second.next;
            }
            pre = pre.next;
        }
        return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoList(result, lists[i]);
        }
        return result;
    }
}