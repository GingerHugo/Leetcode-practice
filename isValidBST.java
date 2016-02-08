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
    private boolean traverseTree(TreeNode root, long left, long right) {
        if (root.val <= left || root.val >= right) {
            return false;
        }
        boolean flag = true;
        if (root.left != null) {
            flag = traverseTree(root.left, left, (long)root.val);
        }
        if (root.right != null) {
            flag = flag && traverseTree(root.right, (long)root.val, right);
        }
        return flag;
    }


    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return traverseTree(root, Long.MIN_VALUE, Long.MAX_VALUE);        
    }
}