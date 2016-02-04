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
    private ListNode dividePartition(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode node1 = dividePartition(lists, left, mid);
        ListNode node2 = dividePartition(lists, mid + 1, right);
        return mergeTwoList(node1, node2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // Divide and conquer is needed!
        if (lists.length == 0) {
            return null;
        }
        return dividePartition(lists, 0, lists.length - 1);
    }
}