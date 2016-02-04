/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode nextChild = tempChild;
            while (root != null) {
                if (root.left != null) {
                    nextChild.next = root.left;
                    nextChild = root.left;
                }
                if (root.right != null) {
                    nextChild.next = root.right;
                    nextChild = root.right;
                }
                root = root.next;
            }
            root = tempChild.next;
        }
    }
}