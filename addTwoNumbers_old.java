/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {   // This does not work any more!!!
        ListNode resultHead = null;
        ListNode result = null;
        ListNode nextNode = new ListNode(0);
        boolean flag = true;
        while(l1 != null && l2 != null) {
            int temp = nextNode.val + l1.val + l2.val;
            result = new ListNode(temp % 10);
            if (flag) {
                resultHead = result;
                flag = false;
            }
            l1 = l1.next;
            l2 = l2.next;
            nextNode.val = temp / 10;
            result = result.next; 
        }
        ListNode l3 = l1 != null ? l1 : l2;
        while (l3 != null) {
            int temp = nextNode.val + l3.val;
            result = new ListNode(temp % 10);
            if (flag) {
                resultHead = result;
                flag = false;
            }
            l3 = l3.next;
            nextNode.val = temp / 10;
            result = result.next; 
        }
        if (nextNode.val != 0) {
            result = new ListNode(nextNode.val);
        }
        return resultHead;
    }
}