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
	private boolean isSame(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p != null && q != null && p.val == q.val) {
        	return (isSame(p.right, q.left) && isSame(p.left, q.right));
        }
        return false;
	}


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
        	return true;
        }
        return isSame(root.left, root.right);
    }
}