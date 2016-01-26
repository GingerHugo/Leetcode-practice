/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null; 
        ListNode result = new ListNode(0);
        ListNode curNode = null;
        int temp = 0;
        while(l1 != null || l2 != null) {
            if (curNode != null) {
                curNode.next = new ListNode(0);
                curNode = curNode.next;
            }
            else curNode = result;
            temp /= 10;
            temp += curNode.val;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            curNode.val = temp % 10;
        }
        if (temp / 10 != 0) curNode.next = new ListNode(1);
        return result;
    }
}