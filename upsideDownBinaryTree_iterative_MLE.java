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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (root.left != null) {
            TreeNode leftNext = root.left.left;
            TreeNode rightNext = root.left.right;
            root.left.left = right;
            root.left.right = left;
            left = leftNext;
            right = rightNext;
            root = root.left;
        }
        return root;
    }
}