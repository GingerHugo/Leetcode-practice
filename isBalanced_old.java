/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        boolean level = false;
        while(!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0;i < n; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                if (temp.left == null || temp.right == null) {
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
        }
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (temp.left != null || temp.right != null) {
                return false;
            }   
        }
        return true;
    }
}