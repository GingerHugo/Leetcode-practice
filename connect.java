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
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            TreeLinkNode temp = queue.poll();
            if (temp.left != null) {
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
            for (int i = 1; i < n; i++) {
                TreeLinkNode node = queue.poll();
                temp.next = node;
                if (node.left != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                temp = node;
            }
        }
    }
}