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
        TreeNode left = null;
        TreeNode right = null;
        TreeNode nodeNext = null;
        while (root != null) {
            nodeNext = root.left;
            root.left = left;
            left = root.right;
            root.right = right;
            right = root;
            root = nodeNext;
        }
        return right;
    }
}