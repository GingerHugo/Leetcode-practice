/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        int count = 0;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            count++;
            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if (flag) {
            ListNode result = head;
            fast = result;
            for (int i = 0; i < count; i++) {
                fast = fast.next;
            }
            while (fast != result) {
                fast = fast.next;
                result = result.next;
            }
            return result;
        }
        else {
            return null;
        }
    }
}