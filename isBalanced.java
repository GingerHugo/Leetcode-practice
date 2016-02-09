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
    private boolean flag = true;
    private int traverseTree(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left = traverseTree(root.left, depth + 1);
        int right = traverseTree(root.right, depth + 1);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return left > right ? left : right;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        traverseTree(root, 0);
        return flag;
    }
}