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
    private int traverseTree(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int treeDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            treeDepth = traverseTree(root.left, depth + 1); 
        }
        if (root.right != null) {
            treeDepth = Math.min(treeDepth, traverseTree(root.right, depth + 1));
        }
        return treeDepth == Integer.MAX_VALUE ? depth + 1 : treeDepth;
    }   

    public int minDepth(TreeNode root) {
        return traverseTree(root, 0);
    }
}