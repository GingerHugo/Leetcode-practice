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
    private TreeNode newRoot = null;
    private TreeNode traverseTree(TreeNode root) {
        if (root.left == null) {
            newRoot = root;
            return root;
        }
        else {
            TreeNode parent = upsideDownBinaryTree(root.left);
            parent.left = root.right;
            parent.right = root;
            return root;
        }
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root != null) {
            traverseTree(root);
        }
        return newRoot;
    }
}